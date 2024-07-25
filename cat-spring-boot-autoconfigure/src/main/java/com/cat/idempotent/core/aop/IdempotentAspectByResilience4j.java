package com.cat.idempotent.core.aop;

import com.cat.idempotent.core.annotation.Idempotent;
import com.cat.idempotent.core.exception.RepeatException;
import com.cat.idempotent.core.keyresolver.IdempotentKeyResolver;
import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import io.github.resilience4j.ratelimiter.RateLimiterRegistry;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.util.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author _qiu
 */
@Aspect
public class IdempotentAspectByResilience4j {
    @SuppressWarnings("ALL")
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(IdempotentAspectByResilience4j.class);
    private final Map<Class<? extends IdempotentKeyResolver>, IdempotentKeyResolver> keyResolvers;
    private final Map<String,RateLimiter> limiterMap=new ConcurrentHashMap<>();

    private final RateLimiterRegistry rateLimiterRegistry;

    public IdempotentAspectByResilience4j(List<IdempotentKeyResolver> keyResolvers, RateLimiterRegistry rateLimiterRegistry) {
        this.keyResolvers = keyResolvers.stream().collect(Collectors.toMap(IdempotentKeyResolver::getClass, o->o));/*CollUtil.convertMap(keyResolvers, IdempotentKeyResolver::getClass);*/
        this.rateLimiterRegistry = rateLimiterRegistry;
    }

    @Before("@annotation(idempotent)")
    public void beforePointCut(JoinPoint joinPoint, Idempotent idempotent) {
        IdempotentKeyResolver keyResolver = keyResolvers.get(idempotent.keyResolver());
        Assert.notNull(keyResolver, "找不到对应的 IdempotentKeyResolver");
        // 解析 Key
        String key = keyResolver.resolver(joinPoint, idempotent);
        RateLimiter rateLimiter = limiterMap.computeIfAbsent(key, k -> createRateLimiter(k,idempotent));
        // 尝试获取许可，等待一定时间
        boolean permissionGranted = rateLimiter.acquirePermission(1);

        if (!permissionGranted) {
            log.error("[beforePointCut][方法({}) 参数({}) 存在重复请求]", joinPoint.getSignature().toString(), joinPoint.getArgs());
            throw new RepeatException("repeat ask");
        }
    }

    private RateLimiter createRateLimiter(String key,Idempotent idempotent) {
        RateLimiterConfig config = RateLimiterConfig
                .custom()
                //每段时间只有一个令牌
                .limitForPeriod(1)
                //刷新令牌的时间
                .limitRefreshPeriod(Duration.ofSeconds(idempotent.timeUnit().toSeconds(idempotent.timeout())))
                //获取令牌超时的时间
                .timeoutDuration(Duration.ZERO)
                .build();

        return rateLimiterRegistry.rateLimiter(key, config);
    }
}

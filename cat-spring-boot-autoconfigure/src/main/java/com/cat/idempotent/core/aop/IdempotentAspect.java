package com.cat.idempotent.core.aop;


import cn.hutool.core.collection.CollUtil;
import com.cat.encrypt.MybatisClearInterceptor;
import com.cat.idempotent.core.annotation.Idempotent;
import com.cat.idempotent.core.exception.RepeatException;
import com.cat.idempotent.core.keyresolver.IdempotentKeyResolver;
import com.cat.idempotent.core.redis.IdempotentRedisDAO;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 拦截声明了 {@link Idempotent} 注解的方法，实现幂等操作
 *
 * @author 芋道源码
 */
@Aspect
public class IdempotentAspect {
    @SuppressWarnings("ALL")
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(IdempotentAspect.class);

    /**
     * IdempotentKeyResolver 集合
     */
    private final Map<Class<? extends IdempotentKeyResolver>, IdempotentKeyResolver> keyResolvers;

    private final IdempotentRedisDAO idempotentRedisDAO;

    public IdempotentAspect(List<IdempotentKeyResolver> keyResolvers, IdempotentRedisDAO idempotentRedisDAO) {
        this.keyResolvers = keyResolvers.stream().collect(Collectors.toMap(IdempotentKeyResolver::getClass, o->o));/*CollUtil.convertMap(keyResolvers, IdempotentKeyResolver::getClass);*/
        this.idempotentRedisDAO = idempotentRedisDAO;
    }

    @Before("@annotation(idempotent)")
    public void beforePointCut(JoinPoint joinPoint, Idempotent idempotent) {
        // 获得 IdempotentKeyResolver
        IdempotentKeyResolver keyResolver = keyResolvers.get(idempotent.keyResolver());
        Assert.notNull(keyResolver, "找不到对应的 IdempotentKeyResolver");
        // 解析 Key
        String key = keyResolver.resolver(joinPoint, idempotent);

        // 锁定 Key。
        boolean success = idempotentRedisDAO.setIfAbsent(key, idempotent.timeout(), idempotent.timeUnit());
        // 锁定失败，抛出异常
        if (!success) {
            log.info("[beforePointCut][方法({}) 参数({}) 存在重复请求]", joinPoint.getSignature().toString(), joinPoint.getArgs());
            throw new RepeatException("repeat ask");
        }
    }

}

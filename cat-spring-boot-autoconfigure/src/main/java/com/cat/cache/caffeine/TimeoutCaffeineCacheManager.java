package com.cat.cache.caffeine;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.CaffeineSpec;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.cache.Cache;
import org.springframework.cache.caffeine.CaffeineCacheManager;

import java.time.Duration;

/**
 * 仿写{@link com.cat.cache.redis.TimeoutRedisCacheManager}
 * @author _qiu
 */
public class TimeoutCaffeineCacheManager extends CaffeineCacheManager {
    private static final String SPLIT = "#";
    CacheProperties cacheProperties;
    String spec;

    public TimeoutCaffeineCacheManager(CacheProperties cacheProperties) {
        super();
        this.cacheProperties = cacheProperties;
        this.spec=cacheProperties.getCaffeine().getSpec();
        if(this.spec==null){
            this.spec="";
        }
    }

    @Override
    protected Cache createCaffeineCache(String name) {
        if (StrUtil.isEmpty(name)) {
            return super.createCaffeineCache(name);
        }
        // 如果使用 # 分隔，大小不为 2，则说明不使用自定义过期时间
        String[] names = StrUtil.splitToArray(name, SPLIT);
        if (names.length != 2) {
            return super.createCaffeineCache(name);
        }
        names[1] = StrUtil.subBefore(names[1], StrUtil.COLON, false);
        // 解析时间
        CaffeineSpec parse = CaffeineSpec.parse(spec);
        Duration duration = parseDuration(names[1]);
        return adaptCaffeineCache(name, Caffeine.from(parse).expireAfterWrite(duration).build());
    }

    /**
     * 解析过期时间 Duration
     *
     * @param ttlStr 过期时间字符串
     * @return 过期时间 Duration
     */
    private Duration parseDuration(String ttlStr) {
        if(ttlStr.toCharArray()[0]=='-'){
            ttlStr="100000d";
        }
        String timeUnit = StrUtil.subSuf(ttlStr, -1);
        switch (timeUnit) {
            case "d":
                return Duration.ofDays(removeDurationSuffix(ttlStr));
            case "h":
                return Duration.ofHours(removeDurationSuffix(ttlStr));
            case "m":
                return Duration.ofMinutes(removeDurationSuffix(ttlStr));
            case "s":
                return Duration.ofSeconds(removeDurationSuffix(ttlStr));
            default:
                return Duration.ofSeconds(Long.parseLong(ttlStr));
        }
    }

    /**
     * 移除多余的后缀，返回具体的时间
     *
     * @param ttlStr 过期时间字符串
     * @return 时间
     */
    private Long removeDurationSuffix(String ttlStr) {
        return NumberUtil.parseLong(StrUtil.sub(ttlStr, 0, ttlStr.length() - 1));
    }
}
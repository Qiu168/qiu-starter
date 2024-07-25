package com.example.www;

import com.cat.idempotent.core.exception.RepeatException;
import lombok.SneakyThrows;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @author _qiu
 */
@Component
public class RedisCache {
    @SneakyThrows
    @Cacheable(cacheNames = {"123#20"},key = "#id",cacheManager = "timeoutCaffeineCacheManager")
    //@Idempotent
    public String RedisCache(String id) throws RepeatException {
        System.out.println("begin");
        return "abc";
    }
}

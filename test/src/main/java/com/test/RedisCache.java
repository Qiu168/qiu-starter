package com.test;

import com.cat.idempotent.core.annotation.Idempotent;
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
    @Cacheable(cacheNames = {"123#-1"},key = "#id",cacheManager = "timeoutCaffeineCacheManager")
    //@Idempotent
    public P RedisCache(String id) throws RepeatException {
        Thread.sleep(1000);
        System.out.println("begin");
        return new P("name","password","email@email.email");
    }
}

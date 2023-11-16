package com.test;

import com.cat.idempotent.core.annotation.Idempotent;
import lombok.SneakyThrows;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @author _qiu
 */
@Component
public class RedisCache {
    //@SneakyThrows
    //@Cacheable(cacheNames = {"123"},key = "#id",cacheManager = "timeoutRedisCacheManager")
    @Idempotent
    public P RedisCache(String id){
        //Thread.sleep(1000);
        System.out.println("begin");
        return new P("name","password","email@email.email");
    }
}

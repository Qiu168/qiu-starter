package com.test;

import com.cat.cache.caffeine.TimeoutCaffeineCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Cache {
    @Autowired
    TimeoutCaffeineCacheManager timeoutCaffeineCacheManager;

    public org.springframework.cache.Cache myCache() {
        return timeoutCaffeineCacheManager.getCache("myCache");
    }
}

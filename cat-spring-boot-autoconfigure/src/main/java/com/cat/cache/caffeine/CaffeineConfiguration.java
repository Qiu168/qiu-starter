package com.cat.cache.caffeine;

import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author _qiu
 */
@EnableCaching
@Configuration
@EnableConfigurationProperties({CacheProperties.class})
@ConditionalOnProperty(value = "cache.timeout.caffeine.enable",havingValue = "true")
public class CaffeineConfiguration {
    @Bean
    @Primary
    public CacheManager timeoutCaffeineCacheManager(CacheProperties cacheProperties){
        return new TimeoutCaffeineCacheManager(cacheProperties);
    }
}

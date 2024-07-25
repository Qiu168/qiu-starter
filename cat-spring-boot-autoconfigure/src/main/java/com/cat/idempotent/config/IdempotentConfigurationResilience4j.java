package com.cat.idempotent.config;

import com.cat.idempotent.core.aop.IdempotentAspectByResilience4j;
import com.cat.idempotent.core.keyresolver.IdempotentKeyResolver;
import com.cat.idempotent.core.keyresolver.impl.DefaultIdempotentKeyResolver;
import com.cat.idempotent.core.keyresolver.impl.ExpressionIdempotentKeyResolver;
import io.github.resilience4j.ratelimiter.internal.InMemoryRateLimiterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author _qiu
 */
@Configuration
public class IdempotentConfigurationResilience4j {
    @Bean
    public IdempotentAspectByResilience4j idempotentAspect(List<IdempotentKeyResolver> keyResolvers) {
        return new IdempotentAspectByResilience4j(keyResolvers, new InMemoryRateLimiterRegistry());
    }

    // ========== 各种 IdempotentKeyResolver Bean ==========
    @Bean
    public DefaultIdempotentKeyResolver defaultIdempotentKeyResolver() {
        return new DefaultIdempotentKeyResolver();
    }

    @Bean
    public ExpressionIdempotentKeyResolver expressionIdempotentKeyResolver() {
        return new ExpressionIdempotentKeyResolver();
    }



}

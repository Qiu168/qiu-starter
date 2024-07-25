package com.cat.idempotent.config;

import com.cat.idempotent.core.aop.IdempotentAspectByRedis;
import com.cat.idempotent.core.keyresolver.IdempotentKeyResolver;
import com.cat.idempotent.core.redis.IdempotentRedisDAO;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;

/**
 * @author _qiu
 */
@AutoConfigureAfter(RedisAutoConfiguration.class)
@ConditionalOnSingleCandidate(RedisConnectionFactory.class)
public class IdempotentConfigurationRedis {

    @Bean
    public IdempotentAspectByRedis idempotentAspect(List<IdempotentKeyResolver> keyResolvers, IdempotentRedisDAO idempotentRedisDAO) {
        return new IdempotentAspectByRedis(keyResolvers, idempotentRedisDAO);
    }
    @Bean
    public IdempotentRedisDAO idempotentRedisDAO(StringRedisTemplate stringRedisTemplate) {
        return new IdempotentRedisDAO(stringRedisTemplate);
    }



}

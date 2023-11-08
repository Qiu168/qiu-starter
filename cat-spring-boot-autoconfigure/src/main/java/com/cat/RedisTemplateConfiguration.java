package com.cat;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.StringRedisSerializer;


/**
 * todo:建议优化为@EnableJsonRedis，或者直接叫JsonRedisTemplate得了
 * @author 14629
 */
@Slf4j
@EnableCaching
@Configuration
@AutoConfigureAfter(RedisAutoConfiguration.class)
@ConditionalOnSingleCandidate(RedisConnectionFactory.class)
//@ConditionalOnProperty(prefix = "cat", value = "redis", matchIfMissing = true)
public class RedisTemplateConfiguration extends CachingConfigurerSupport {
    @Bean
    @ConditionalOnSingleCandidate(RedisConnectionFactory.class)
    @SuppressWarnings(value = { "unchecked", "rawtypes" })
    public JsonRedisTemplate jsonRedisTemplate(RedisConnectionFactory connectionFactory) {
        log.info("bean :JsonTemplate");
        JsonRedisTemplate<Object,Object> template = new JsonRedisTemplate<>();
        template.setConnectionFactory(connectionFactory);

        FastJson2JsonRedisSerializer serializer = new FastJson2JsonRedisSerializer(Object.class);

        // 使用StringRedisSerializer来序列化和反序列化redis的key值
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(serializer);

        // Hash的key也采用StringRedisSerializer的序列化方式
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(serializer);

        template.afterPropertiesSet();
        return template;
    }
}

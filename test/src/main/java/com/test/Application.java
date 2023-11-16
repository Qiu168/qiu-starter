package com.test;

import com.cat.idempotent.core.redis.IdempotentRedisDAO;
import com.cat.log.EnableLog;
import com.cat.redis.JsonRedisTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author 14629
 */
@SpringBootApplication
@EnableAspectJAutoProxy
@EnableLog
@EnableCaching
public class Application {

    @Autowired
    JsonRedisTemplate<Object,Object> jsonRedisTemplate;
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        RedisCache bean = context.getBean(RedisCache.class);
        IdempotentRedisDAO bean1 = context.getBean(IdempotentRedisDAO.class);
        //RedisCache bean = context.getBean(RedisT.class);
        bean.RedisCache("123");
        bean.RedisCache("123");
        bean.RedisCache("123");
        bean.RedisCache("123");
//        test bean1 = context.getBean(test.class);
//        P p=new P("123","456","789");
//        System.out.println(JSON.toJSONString(p));
//        String s = bean1.test1(p);
//        MustBeEnumTest mustBeEnumTest=new MustBeEnumTest();
    }
}

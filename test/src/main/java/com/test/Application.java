package com.test;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson2.JSON;
import com.cat.cache.caffeine.TimeoutCaffeineCacheManager;
import com.cat.idempotent.core.exception.RepeatException;
import com.cat.idempotent.core.redis.IdempotentRedisDAO;
import com.cat.log.EnableLog;
import com.cat.cache.redis.JsonRedisTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author 14629
 */
@SpringBootApplication
@EnableAspectJAutoProxy
@EnableLog
@EnableCaching
public class Application {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        //RedisCache bean = context.getBean(RedisCache.class);
        //IdempotentRedisDAO bean1 = context.getBean(IdempotentRedisDAO.class);
        JsonRedisTemplate<Object,Object> bean = context.getBean(JsonRedisTemplate.class);
//        try {
//            bean.RedisCache("456");
//            bean.RedisCache("456");
//            bean.RedisCache("456");
//            bean.RedisCache("123");
//        } catch (RepeatException e) {
//            System.out.println("exception");
//        }
//        Thread.sleep(3000);
//        bean.RedisCache("123");
//        TimeoutCaffeineCacheManager bean2 = context.getBean(TimeoutCaffeineCacheManager.class);
//        bean2.getCacheNames().forEach(System.out::println);
////        test bean1 = context.getBean(test.class);
//        P p=new P("123","456","789");
//        System.out.println(JSON.toJSONString(p));
//        String s = bean1.test1(p);
//        MustBeEnumTest mustBeEnumTest=new MustBeEnumTest();
        bean.opsForValue().set("777777777777777",new P("123","456","789"),20, TimeUnit.SECONDS);
//        Map o = (Map) bean.opsForValue().get("777777777777777");
//        P p = BeanUtil.mapToBean(o, P.class, false,null);
//        System.out.println(p);
        P p = bean.getJsonObj("777777777777777", P.class);
        System.out.println(p);
        Object o = bean.opsForValue().get("777777777777777");
        System.out.println(o instanceof Map);
        System.out.println(o instanceof String);
        System.out.println(o);
    }
}

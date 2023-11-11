package com.test;

import com.cat.log.EnableLog;
import com.cat.redis.JsonRedisTemplate;
import com.cat.MyService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author 14629
 */
@SpringBootApplication
@EnableAspectJAutoProxy
@EnableLog
public class Application {

    @Autowired
    JsonRedisTemplate<Object,Object> jsonRedisTemplate;
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        test bean1 = context.getBean(test.class);
        P p=new P("123","456");
        String s = bean1.test1(p);
    }
}

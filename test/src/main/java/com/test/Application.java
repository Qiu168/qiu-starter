package com.test;

import com.cat.MyService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author 14629
 */
@SpringBootApplication
public class Application {
    @AllArgsConstructor
    @Data
    static class P{
        String name;
    }
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        MyService bean = context.getBean(MyService.class);
        //Object redis = context.getBean("redis");
        RedisTemplate redisTemplate = (RedisTemplate)context.getBean("redis");
        P p=new P("zhangsan");
        redisTemplate.opsForValue().set("zhangsan",p);
        Object zhangsan = redisTemplate.opsForValue().get("zhangsan");
        System.out.println(zhangsan);
        System.out.println(bean.addPrefix("hello"));
        test bean1 = context.getBean(test.class);
        bean1.test1();
    }
}

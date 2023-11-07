package com.test;

import com.cat.MyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author 14629
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        MyService bean = context.getBean(MyService.class);
        System.out.println(bean.addPrefix("hello"));
        test bean1 = context.getBean(test.class);
        bean1.test1();
    }
}

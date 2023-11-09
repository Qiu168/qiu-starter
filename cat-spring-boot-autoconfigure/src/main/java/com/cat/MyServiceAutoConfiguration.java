package com.cat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 14629
 */
// 必须，指明这是一个配置类
@Configuration
// 可选，表示在web应用中才配置
//@ConditionalOnWebApplication
// 必须，绑定我们的配置文件类
@EnableConfigurationProperties(MyProperties.class)
// 可选，表示可以在配置文件中，通过myservice.enable来设置是否配置该类
// 如果没有指明，则默认为true，即表示配置，如果指明为false，就不配置了
@ConditionalOnProperty(prefix = "cat", value = "enable", matchIfMissing = true)
public class MyServiceAutoConfiguration {

	// 注入配置文件
    @Autowired
    MyProperties myProperties;
	// 用@Bean将MyService注入到Spring容器中，并把配置文件传进去，以供MyService使用
    @Bean
    public MyService myService() {
        return new MyService(myProperties);
    }
}

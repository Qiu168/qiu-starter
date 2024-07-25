package com.cat.cache.caffeine;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * todo
 * 动态配置指定bean的名字
 */
//@Component
public class DynamicBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    //@Value("${cache.timeout.caffeine.name:timeoutCaffeineCacheManager}")
    private String name;
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        // 在这里可以动态注册 Bean 别名或者修改 Bean 定义
        String[] beanNames = beanFactory.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            // 根据需要的条件判断是否要修改 Bean 定义
            if ("timeoutCaffeineCacheManager".equals(beanName)) {
                // 动态添加别名
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+name);
                beanFactory.registerAlias(beanName, name);
            }
        }
    }
}
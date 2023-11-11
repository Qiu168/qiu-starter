package com.cat.log;

import java.lang.annotation.*;

/**
 * 需要 {@link org.springframework.context.annotation.EnableAspectJAutoProxy}才可以代理运行
 * @author _qiu
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    /**
     * 模块
     */
    public String title() default "";

    /**
     * 是否保存请求的参数
     */
    public boolean isSaveRequestData() default true;

    /**
     * 是否保存响应的参数
     */
    public boolean isSaveResponseData() default true;

    /**
     * 排除请求类中的字段，比如请求类中有一个字段叫做password，就不会被日志
     * 默认字段@see ILogAspect#EXCLUDE_PROPERTIES
     * 排除指定的请求参数
     */
    public String[] excludeParamNames() default {};
}

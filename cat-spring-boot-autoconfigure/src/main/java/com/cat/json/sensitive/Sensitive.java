package com.cat.json.sensitive;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 只会影响springmvc的也就是jackson的序列化
 * 字段去敏
 * @author _qiu
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@JacksonAnnotationsInside
@JsonSerialize(using = SensitiveJsonSerializer.class)
public @interface Sensitive {
    /**
     * 脱敏实现类
     */
    Class<? extends Desensitize> strategyClass() default SensitiveStrategy.class;

    /**
     * enum中的实例名称
     * @see SensitiveConstants SensitiveConstants
     *
     * @see SensitiveStrategy SensitiveStrategy
     */
    String strategy();
}

package com.cat.valid;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * todo
 * 这是一个编译时注解，用来放到接口上，继承此接口的实现类必须是ENUM
 * @author 14629
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.TYPE)
public @interface MustBeEnum {
}

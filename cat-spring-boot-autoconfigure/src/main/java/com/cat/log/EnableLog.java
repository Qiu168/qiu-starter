package com.cat.log;


import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author _qiu
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(LogAspect.class)
public @interface EnableLog {
}

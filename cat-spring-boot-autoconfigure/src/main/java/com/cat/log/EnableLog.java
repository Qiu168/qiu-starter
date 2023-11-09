package com.cat.log;


import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author 14629
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(LogAspect.class)
public @interface EnableLog {
}

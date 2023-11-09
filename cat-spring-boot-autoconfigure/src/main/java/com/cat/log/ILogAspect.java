package com.cat.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 继承此方法可以重写@Log注解的增强，实现类要加上@Aspect注解并注册进容器内
 * @author 14629
 */

public interface ILogAspect {
    @Pointcut(value = "@annotation(Log)")
    default void pointCut() {
    }
    @Around(value = "pointCut()")
    Object doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint);
}

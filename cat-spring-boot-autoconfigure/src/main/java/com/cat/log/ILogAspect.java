package com.cat.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 继承此方法可以重写{@link Log}注解的增强，实现类要加上@Aspect注解并注册进容器内
 * @author _qiu
 */
public interface ILogAspect {
    /**
     * 排除敏感属性字段
     */
    String[] EXCLUDE_PROPERTIES = {"password", "oldPassword", "newPassword", "confirmPassword"};
    @Pointcut(value = "@annotation(Log)")
    default void logPointCut() {
    }
    @Around(value = "@annotation(log)")
    Object logAdvice(ProceedingJoinPoint proceedingJoinPoint,Log anLog);
}

package com.test;

import com.cat.log.ILogAspect;
import com.cat.log.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author _qiu
 */
@Component
@Aspect
public class LogAspect implements ILogAspect {
    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(LogAspect.class);
    //</editor-fold>

    @Override
    public Object logAdvice(ProceedingJoinPoint proceedingJoinPoint, Log log) {
        LogAspect.log.info("直接重写直接重写直接重写直接重写直接重写直接重写");
        long start = System.currentTimeMillis();
        try {
            Object result = proceedingJoinPoint.proceed();
            long end = System.currentTimeMillis();
            LogAspect.log.info("直接重写直接重写直接重写直接重写result：{}", result);
            LogAspect.log.info("直接重写直接重写直接重写直接重写耗时：{} 毫秒", end - start);
            return result; // 返回原始方法的返回值
        } catch (Throwable throwable) {
            LogAspect.log.error("发生异常: {}", throwable.getMessage());
            throw new RuntimeException(throwable); // 抛出异常或者返回一个合适的值
        }
    }
}

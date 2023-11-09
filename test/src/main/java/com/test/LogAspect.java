package com.test;

import com.cat.log.ILogAspect;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author 14629
 */
@Component
@Slf4j
@Aspect
public class LogAspect implements ILogAspect {
    @Override
    public Object doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        log.info("直接重写直接重写直接重写直接重写直接重写直接重写");
        long start = System.currentTimeMillis();
        try {
            Object result = proceedingJoinPoint.proceed();
            long end = System.currentTimeMillis();
            log.info("直接重写直接重写直接重写直接重写result：{}",result);
            log.info("直接重写直接重写直接重写直接重写耗时：{} 毫秒", end - start);
            return result; // 返回原始方法的返回值
        } catch (Throwable throwable) {
            log.error("发生异常: {}" , throwable.getMessage());
            throw new RuntimeException(throwable); // 抛出异常或者返回一个合适的值
        }
    }
}

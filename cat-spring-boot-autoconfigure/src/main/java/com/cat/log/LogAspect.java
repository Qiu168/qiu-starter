package com.cat.log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Component;

/**
 * @author 14629
 */
@Aspect
@Component
@Slf4j
//@Order()
//@ConditionalOnMissingBean(name="logAspect")
@ConditionalOnMissingBean(ILogAspect.class)
public class LogAspect implements ILogAspect{
    @Around(value = "pointCut()")
    @Override
    public Object doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        log.info("环绕通知的目标方法名：" + proceedingJoinPoint.getSignature().getName());
        long start = System.currentTimeMillis();
        try {
            Object result = proceedingJoinPoint.proceed();
            long end = System.currentTimeMillis();
            log.info("result：{}",result);
            log.info("耗时：{} 毫秒", end - start);
            return result; // 返回原始方法的返回值
        } catch (Throwable throwable) {
            log.error("发生异常: {}" , throwable.getMessage());
            throw new RuntimeException(throwable); // 抛出异常或者返回一个合适的值
        }
    }
}

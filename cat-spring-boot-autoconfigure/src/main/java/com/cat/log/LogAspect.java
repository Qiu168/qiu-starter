package com.cat.log;

import com.alibaba.fastjson2.JSON;
import com.cat.log.filter.PropertyPreExcludeFilter;
import com.cat.utils.SpringUtil;
import com.cat.utils.StringUtil;
import org.apache.commons.lang3.ArrayUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.Map;

/**
 * @author _qiu
 */
@Aspect
@Component
@ConditionalOnMissingBean(ILogAspect.class)
public class LogAspect implements ILogAspect {
    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(LogAspect.class);

    //private static final String[] EXCLUDE_PROPERTIES = {"password", "oldPassword", "newPassword", "confirmPassword"};
    //</editor-fold>
    /**
     * @see ILogAspect
     * 默认排除敏感属性字段
     */
    @Around("@annotation(anLog)")
    @Override
    public Object logAdvice(ProceedingJoinPoint proceedingJoinPoint, Log anLog) {
        if (!anLog.title().isEmpty()) {
            log.info("title:{}", anLog.title());
        }
        String className = proceedingJoinPoint.getTarget().getClass().getName();
        String methodName = proceedingJoinPoint.getSignature().getName();
        log.info("环绕通知的目标方法名：" + className + "." + methodName + "()");
        if (anLog.isSaveRequestData()) {
            String params = argsArrayToString(proceedingJoinPoint.getArgs(), anLog.excludeParamNames());
            log.info("请求参数为:{}", params);
        }
        long start = System.currentTimeMillis();
        try {
            Object result = proceedingJoinPoint.proceed();
            if (anLog.isSaveResponseData()) {
                log.info("result：{}", result);
            }
            return result; // 返回原始方法的返回值
        } catch (Throwable throwable) {
            log.error("发生异常: {}", throwable.getMessage());
            throw new RuntimeException(throwable); // 抛出异常或者返回一个合适的值
        } finally {
            long end = System.currentTimeMillis();
            log.info("耗时：{} 毫秒", end - start);
        }
    }

    /**
     * todo:重构一下
     */
    private String argsArrayToString(Object[] paramsArray, String[] excludeParamNames) {
        String params = "";
        if (paramsArray != null && paramsArray.length > 0) {
            for (Object o : paramsArray) {
                if (SpringUtil.deduceWebEnvironment()) {
                    if (StringUtil.isNotNull(o) && !isFilterObject(o)) {
                        try {
                            String jsonObj = JSON.toJSONString(o, excludePropertyPreFilter(excludeParamNames));
                            params += jsonObj.toString() + " ";
                        } catch (Exception e) {
                        }
                    }
                } else {
                    if (StringUtil.isNotNull(o)) {
                        try {
                            String jsonObj = JSON.toJSONString(o, excludePropertyPreFilter(excludeParamNames));
                            params += jsonObj.toString() + " ";
                        } catch (Exception e) {
                        }
                    }
                }
            }
        }
        return params.trim();
    }

    /**
     * 忽略敏感属性
     */
    public PropertyPreExcludeFilter excludePropertyPreFilter(String[] excludeParamNames) {
        return new PropertyPreExcludeFilter().addExcludes(ArrayUtils.addAll(EXCLUDE_PROPERTIES, excludeParamNames));
    }

    /**
     * 判断是否需要过滤的对象。
     * 需要在web环境
     * @param o 对象信息。
     * @return 如果是需要过滤的对象，则返回true；否则返回false。
     */
    @SuppressWarnings("rawtypes")
    public boolean isFilterObject(final Object o) {
        Class<?> clazz = o.getClass();
        if (clazz.isArray()) {
            return clazz.getComponentType().isAssignableFrom(MultipartFile.class);
        } else if (Collection.class.isAssignableFrom(clazz)) {
            Collection collection = (Collection) o;
            for (Object value : collection) {
                return value instanceof MultipartFile;
            }
        } else if (Map.class.isAssignableFrom(clazz)) {
            Map map = (Map) o;
            for (Object value : map.entrySet()) {
                Map.Entry entry = (Map.Entry) value;
                return entry.getValue() instanceof MultipartFile;
            }
        }
        return o instanceof MultipartFile || o instanceof HttpServletRequest || o instanceof HttpServletResponse || o instanceof BindingResult;
    }
}

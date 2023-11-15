package com.cat.encrypt;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;

import java.util.Properties;

/**
 * 自动清除
 * 需要手动配置：mybatis-encryptor.auto-clear
 * @author _qiu
 */
@Intercepts({@Signature(type = Executor.class,method = "flushStatements",args = {})})
public class MybatisClearInterceptor implements Interceptor {
    @SuppressWarnings("ALL")
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(MybatisClearInterceptor.class);
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object result = invocation.proceed();
        if(EncryptHelper.hasSituation()){
            log.info("EncryptClear!!!");
        }
        EncryptHelper.clearEncrypt();
        return result;
    }

    @Override
    public Object plugin(Object target) {
        // 包装目标对象，创建代理对象
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
    }
}

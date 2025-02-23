package com.cat.encrypt;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cat.utils.StringUtil;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.*;
import java.lang.reflect.Field;
import java.sql.Statement;
import java.util.*;

/**
 * 出参解密拦截器
 * @author 老马
 */
@Intercepts({@Signature(type = ResultSetHandler.class, method = "handleResultSets", args = {Statement.class})})
public class MybatisDecryptInterceptor implements Interceptor {
    @SuppressWarnings("all")
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(MybatisDecryptInterceptor.class);
    private final EncryptorManager encryptorManager;
    private final EncryptorProperties defaultProperties;
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // 获取执行mysql执行结果
        Object result = invocation.proceed();
        if (result == null) {
            return null;
        }
        EncryptSituation decryptSituation = EncryptHelper.getDecryptSituation();
        if(decryptSituation==null||!decryptSituation.isCancelEncrypt()){
            decryptHandler(result);
        }
        EncryptHelper.clearDecrypt();
        return result;
    }

    /**
     * 解密对象
     *
     * @param sourceObject 待加密对象
     */
    private void decryptHandler(Object sourceObject) {
        if (ObjectUtil.isNull(sourceObject)) {
            return;
        }
        if (sourceObject instanceof Map<?, ?>) {
            new HashSet<>(((Map<?, ?>) sourceObject).values()).forEach(this::decryptHandler);
            return;
        }
        if (sourceObject instanceof List<?>) {
            List<?> sourceList = (List<?>) sourceObject;
            if (CollUtil.isEmpty(sourceList)) {
                return;
            }
            // 判断第一个元素是否含有注解。如果没有直接返回，提高效率
            Object firstItem = sourceList.get(0);
            if (ObjectUtil.isNull(firstItem) || CollUtil.isEmpty(encryptorManager.getFieldCache(firstItem.getClass()))) {
                return;
            }
            ((List<?>) sourceObject).forEach(this::decryptHandler);
            return;
        }
        Set<Field> fields = encryptorManager.getFieldCache(sourceObject.getClass());
        try {
            for (Field field : fields) {
                field.set(sourceObject, this.decryptField(String.valueOf(field.get(sourceObject)), field));
            }
        } catch (Exception e) {
            log.error("处理解密字段时出错", e);
        }
    }

    /**
     * 字段值进行加密。通过字段的批注注册新的加密算法
     *
     * @param value 待加密的值
     * @param field 待加密字段
     * @return 加密后结果
     */
    private String decryptField(String value, Field field) {
        if (ObjectUtil.isNull(value)) {
            return null;
        }
        Encrypt encryptField = field.getAnnotation(Encrypt.class);
        EncryptContext encryptContext = new EncryptContext();
        encryptContext.setAlgorithm(encryptField.algorithm() == AlgorithmType.DEFAULT ? defaultProperties.getAlgorithm() : encryptField.algorithm());
        encryptContext.setEncode(encryptField.encode() == EncodeType.DEFAULT ? defaultProperties.getEncode() : encryptField.encode());
        encryptContext.setPassword(StringUtil.isBlank(encryptField.password()) ? defaultProperties.getPassword() : encryptField.password());
        encryptContext.setPrivateKey(StringUtil.isBlank(encryptField.privateKey()) ? defaultProperties.getPrivateKey() : encryptField.privateKey());
        encryptContext.setPublicKey(StringUtil.isBlank(encryptField.publicKey()) ? defaultProperties.getPublicKey() : encryptField.publicKey());
        encryptContext.setSalt(StringUtil.isBlank(encryptField.salt())? defaultProperties.getSalt():encryptField.salt());
        return this.encryptorManager.decrypt(value, encryptContext);
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
    //<editor-fold defaultstate="collapsed" desc="delombok">
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public MybatisDecryptInterceptor(final EncryptorManager encryptorManager, final EncryptorProperties defaultProperties) {
        this.encryptorManager = encryptorManager;
        this.defaultProperties = defaultProperties;
    //</editor-fold>
    }
}

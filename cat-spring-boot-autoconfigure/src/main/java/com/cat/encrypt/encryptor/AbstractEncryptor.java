package com.cat.encrypt.encryptor;


import com.cat.encrypt.AlgorithmType;
import com.cat.encrypt.EncodeType;
import com.cat.encrypt.EncryptContext;
import com.cat.encrypt.IEncryptor;

/**
 * 所有加密执行者的基类
 *
 * @author 老马
 * @version 4.6.0
 */
public abstract class AbstractEncryptor implements IEncryptor {

    public AbstractEncryptor(EncryptContext context) {
        // 用户配置校验与配置注入
        if(context.getSalt()==null){
            context.setSalt("");
        }
        if(context.getAlgorithm().getClazz()==null){
            context.setAlgorithm(AlgorithmType.MD5);
        }
        if(context.getEncode()==null){
            context.setEncode(EncodeType.HEX);
        }
    }

}

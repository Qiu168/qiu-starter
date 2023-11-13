package com.cat.encrypt;

import com.cat.encrypt.encryptor.*;

/**
 * 算法名称
 *
 * @author 老马
 * @version 4.6.0
 */
public enum AlgorithmType {
    /**
     * 默认 yaml
     */
    DEFAULT(null),
    /**
     * base64
     */
    BASE64(Base64Encryptor.class),
    /**
     * aes
     */
    AES(AesEncryptor.class),
    /**
     * rsa
     */
    RSA(RsaEncryptor.class),
    /**
     * sm2
     */
    SM2(Sm2Encryptor.class),
    /**
     * sm4
     */
    SM4(Sm4Encryptor.class),
    /**
     *
     * MD5
     */
    MD5(Md5Encryptor.class);
    private final Class<? extends AbstractEncryptor> clazz;

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public Class<? extends AbstractEncryptor> getClazz() {
        if (this.clazz==null){
            return Md5Encryptor.class;
        }
        return this.clazz;
    }

    @SuppressWarnings("all")
    private AlgorithmType(final Class<? extends AbstractEncryptor> clazz) {
        this.clazz = clazz;
    }
    //</editor-fold>
}

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
     * 编码
     * base64
     */
    BASE64(Base64Encryptor.class),
    /**
     * 对称
     * aes
     */
    AES(AesEncryptor.class),
    /**
     * 非对称
     * rsa
     */
    RSA(RsaEncryptor.class),
    /**
     * 非对称
     * sm2
     */
    SM2(Sm2Encryptor.class),
    /**
     * 对称
     * sm4
     */
    SM4(Sm4Encryptor.class),
    /**
     * 哈希
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

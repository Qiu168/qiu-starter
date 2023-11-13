package com.cat.encrypt;

import java.lang.annotation.*;

/**
 * 字段加密注解
 * 如果注解和配置文件都不配置{@link Encrypt#algorithm()}{@link Encrypt#encode()}就是MD5和HEX
 * @author 老马
 */
@Documented
@Inherited
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Encrypt {

    /**
     * 加密算法
     */
    AlgorithmType algorithm() default AlgorithmType.DEFAULT;

    /**
     * 秘钥。AES、SM4需要
     */
    String password() default "";

    /**
     * 公钥。RSA、SM2需要
     */
    String publicKey() default "";

    /**
     * 私钥。RSA、SM2需要
     */
    String privateKey() default "";

    /**
     * 编码方式。对加密算法为BASE64的不起作用
     */
    EncodeType encode() default EncodeType.DEFAULT;
    /**
     * 盐。MD5需要
     */
    String salt() default "";
}

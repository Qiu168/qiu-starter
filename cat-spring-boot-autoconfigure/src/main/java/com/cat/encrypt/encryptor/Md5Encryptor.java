package com.cat.encrypt.encryptor;

import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.MD5;
import com.cat.encrypt.AlgorithmType;
import com.cat.encrypt.EncodeType;
import com.cat.encrypt.EncryptContext;


/**
 * @author 14629
 */
public class Md5Encryptor extends AbstractEncryptor {
    private final MD5 md5;

    public Md5Encryptor(EncryptContext context) {
        super(context);
        md5 = SecureUtil.md5();
        md5.setSalt(context.getSalt().getBytes());
    }

    @Override
    public AlgorithmType algorithm() {
        return AlgorithmType.MD5;
    }

    @Override
    public String encrypt(String value, EncodeType encodeType) {
        if (encodeType == EncodeType.HEX) {
            return md5.digestHex(value);
        } else {
            return Base64.encode(md5.digest(value));
        }
    }

    @Override
    public String decrypt(String value) {
        return value;
    }
}

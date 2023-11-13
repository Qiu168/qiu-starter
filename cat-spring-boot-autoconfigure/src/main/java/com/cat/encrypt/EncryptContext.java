package com.cat.encrypt;

/**
 * 加密上下文 用于encryptor传递必要的参数。
 *
 * @author 老马
 * @version 4.6.0
 */
public class EncryptContext {
    /**
     * 默认算法
     */
    private AlgorithmType algorithm;
    /**
     * 安全秘钥
     */
    private String password;
    /**
     * 公钥
     */
    private String publicKey;
    /**
     * 私钥
     */
    private String privateKey;
    /**
     * 编码方式，base64/hex
     */
    private EncodeType encode;
    /**
     * 盐
     */
    private String salt;

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public EncryptContext() {
    }

    /**
     * 默认算法
     */
    @SuppressWarnings("all")
    public AlgorithmType getAlgorithm() {
        return this.algorithm;
    }

    /**
     * 安全秘钥
     */
    @SuppressWarnings("all")
    public String getPassword() {
        return this.password;
    }

    /**
     * 公钥
     */
    @SuppressWarnings("all")
    public String getPublicKey() {
        return this.publicKey;
    }

    /**
     * 私钥
     */
    @SuppressWarnings("all")
    public String getPrivateKey() {
        return this.privateKey;
    }

    /**
     * 编码方式，base64/hex
     */
    @SuppressWarnings("all")
    public EncodeType getEncode() {
        return this.encode;
    }

    /**
     * 盐
     */
    @SuppressWarnings("all")
    public String getSalt() {
        return this.salt;
    }

    /**
     * 默认算法
     */
    @SuppressWarnings("all")
    public void setAlgorithm( AlgorithmType algorithm) {
        if (algorithm==null){
            algorithm=AlgorithmType.MD5;
        }
        this.algorithm = algorithm;
    }

    /**
     * 安全秘钥
     */
    @SuppressWarnings("all")
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * 公钥
     */
    @SuppressWarnings("all")
    public void setPublicKey(final String publicKey) {
        this.publicKey = publicKey;
    }

    /**
     * 私钥
     */
    @SuppressWarnings("all")
    public void setPrivateKey(final String privateKey) {
        this.privateKey = privateKey;
    }

    /**
     * 编码方式，base64/hex
     */
    @SuppressWarnings("all")
    public void setEncode(EncodeType encode) {
        if (encode==null){
            encode=EncodeType.HEX;
        }
        this.encode = encode;
    }

    /**
     * 盐
     */
    @SuppressWarnings("all")
    public void setSalt(final String salt) {
        this.salt = salt;
    }

    @Override
    @SuppressWarnings("all")
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof EncryptContext)) return false;
        final EncryptContext other = (EncryptContext) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$algorithm = this.getAlgorithm();
        final Object other$algorithm = other.getAlgorithm();
        if (this$algorithm == null ? other$algorithm != null : !this$algorithm.equals(other$algorithm)) return false;
        final Object this$password = this.getPassword();
        final Object other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) return false;
        final Object this$publicKey = this.getPublicKey();
        final Object other$publicKey = other.getPublicKey();
        if (this$publicKey == null ? other$publicKey != null : !this$publicKey.equals(other$publicKey)) return false;
        final Object this$privateKey = this.getPrivateKey();
        final Object other$privateKey = other.getPrivateKey();
        if (this$privateKey == null ? other$privateKey != null : !this$privateKey.equals(other$privateKey)) return false;
        final Object this$encode = this.getEncode();
        final Object other$encode = other.getEncode();
        if (this$encode == null ? other$encode != null : !this$encode.equals(other$encode)) return false;
        final Object this$salt = this.getSalt();
        final Object other$salt = other.getSalt();
        if (this$salt == null ? other$salt != null : !this$salt.equals(other$salt)) return false;
        return true;
    }

    @SuppressWarnings("all")
    protected boolean canEqual(final Object other) {
        return other instanceof EncryptContext;
    }

    @Override
    @SuppressWarnings("all")
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $algorithm = this.getAlgorithm();
        result = result * PRIME + ($algorithm == null ? 43 : $algorithm.hashCode());
        final Object $password = this.getPassword();
        result = result * PRIME + ($password == null ? 43 : $password.hashCode());
        final Object $publicKey = this.getPublicKey();
        result = result * PRIME + ($publicKey == null ? 43 : $publicKey.hashCode());
        final Object $privateKey = this.getPrivateKey();
        result = result * PRIME + ($privateKey == null ? 43 : $privateKey.hashCode());
        final Object $encode = this.getEncode();
        result = result * PRIME + ($encode == null ? 43 : $encode.hashCode());
        final Object $salt = this.getSalt();
        result = result * PRIME + ($salt == null ? 43 : $salt.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("all")
    public String toString() {
        return "EncryptContext(algorithm=" + this.getAlgorithm() + ", password=" + this.getPassword() + ", publicKey=" + this.getPublicKey() + ", privateKey=" + this.getPrivateKey() + ", encode=" + this.getEncode() + ", salt=" + this.getSalt() + ")";
    }
    //</editor-fold>
}

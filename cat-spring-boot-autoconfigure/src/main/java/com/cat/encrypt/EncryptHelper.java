package com.cat.encrypt;


/**
 * <p>
 *     仿写 {@link com.github.pagehelper.PageHelper}
 * </p>
 * 可以使用runCancelEncryptMethod
 * 或手动clear
 * <p>
 *     todo:returnUndecrypted和returnUnencrypted还没实现
 * </p>
 * 实现了执行一个sql就自动{@link EncryptHelper#clearEncrypt()}
 * 需配置
 * @see EncryptorConfig#mybatisClearInterceptor(EncryptorManager) 自动清除拦截器<p>
 *
 * @author _qiu
 */
public class EncryptHelper implements AutoCloseable {
    private static final ThreadLocal<EncryptSituation> LOCAL_ENCRYPT=new ThreadLocal<>();
    public static void cancelEncrypt(){
        LOCAL_ENCRYPT.set(new EncryptSituation(true,true));
    }
    public static void returnUnencrypted(){
        LOCAL_ENCRYPT.set(new EncryptSituation(false,false));
    }
    public static EncryptSituation getEncryptSituation(){
        return LOCAL_ENCRYPT.get();
    }
    public static void clearEncrypt(){
        LOCAL_ENCRYPT.remove();
    }
    public static void cancelDecrypt(){
        LOCAL_ENCRYPT.set(new EncryptSituation(true,true));
    }
    public static void returnUndecrypted(){
        LOCAL_ENCRYPT.set(new EncryptSituation(false,false));
    }
    public static EncryptSituation getDecryptSituation(){
        return LOCAL_ENCRYPT.get();
    }
    public static void clearDecrypt(){
        LOCAL_ENCRYPT.remove();
    }
    public static boolean hasSituation(){
        return LOCAL_ENCRYPT.get()!=null;
    }
    public static void runCancelEncryptMethod(Runnable method){
        cancelEncrypt();
        method.run();
        clearEncrypt();
    }
    @Override
    public void close() {
        clearEncrypt();
    }

}

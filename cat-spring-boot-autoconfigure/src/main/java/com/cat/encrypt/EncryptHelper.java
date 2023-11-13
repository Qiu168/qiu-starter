package com.cat.encrypt;


/**
 * <p>
 *     仿写 {@link com.github.pagehelper.PageHelper}
 * </p>
 * 但是没有实现执行一个sql就自动{@link EncryptHelper#clearEncrypt()} 所以需要手动clearEncrypt<p>
 * 或使用runCancelEncryptMethod
 * <p>
 *     todo:returnUndecrypted和returnUnencrypted还没实现
 * </p>
 *
 * @author 14629
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

package com.cat.json.sensitive;

import cn.hutool.core.util.DesensitizedUtil;
import java.util.function.Function;

/**
 * 脱敏策略
 *
 * @author Yjoioooo
 * @version 3.6.0
 */
public enum SensitiveStrategy implements Desensitize {
    /**
     * 身份证脱敏
     */
    ID_CARD(s -> DesensitizedUtil.idCardNum(s, 3, 4)), /**
     * 手机号脱敏
     */
    PHONE(DesensitizedUtil::mobilePhone), /**
     * 地址脱敏
     */
    ADDRESS(s -> DesensitizedUtil.address(s, 8)), /**
     * 邮箱脱敏
     */
    EMAIL(DesensitizedUtil::email), /**
     * 银行卡
     */
    BANK_CARD(DesensitizedUtil::bankCard);
    //可自行添加其他脱敏策略
    private final Function<String, String> desensitizer;

    @Override
    public Function<String, String> desensitizer() {
        return desensitizer;
    }

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    private SensitiveStrategy(final Function<String, String> desensitizer) {
        this.desensitizer = desensitizer;
    }
    //</editor-fold>
}

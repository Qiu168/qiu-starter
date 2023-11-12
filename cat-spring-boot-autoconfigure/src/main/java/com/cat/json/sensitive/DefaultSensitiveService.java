package com.cat.json.sensitive;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Component;

/**
 * 默认实现
 * @author 14629
 */
@Component
@ConditionalOnMissingBean(SensitiveService.class)
public class DefaultSensitiveService implements SensitiveService{
    @Override
    public boolean isSensitive() {
        return true;
    }
}

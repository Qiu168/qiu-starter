package com.cat.json.sensitive;

import java.util.function.Function;

/**
 * 脱敏需实现此接口
 * @author 14629
 */
public interface Desensitize {
    Function<String, String> desensitizer();
}

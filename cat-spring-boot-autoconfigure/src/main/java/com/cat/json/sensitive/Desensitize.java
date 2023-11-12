package com.cat.json.sensitive;

import com.cat.valid.MustBeEnum;

import java.util.function.Function;

/**
 * 脱敏枚举类需实现此接口
 * @author 14629
 */
@MustBeEnum
public interface Desensitize {
    Function<String, String> desensitizer();
}

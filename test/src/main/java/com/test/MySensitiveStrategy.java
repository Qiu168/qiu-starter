package com.test;

import com.cat.json.sensitive.Desensitize;

import java.util.function.Function;

/**
 * @author 14629
 */

public enum MySensitiveStrategy implements Desensitize {
    ;

    @Override
    public Function<String, String> desensitizer() {
        return null;
    }
}

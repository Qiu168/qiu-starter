package com.test;

import com.cat.json.sensitive.Desensitize;

import java.util.function.Function;

/**
 * @author _qiu
 */

public enum MySensitiveStrategy implements Desensitize {
    ;

    @Override
    public Function<String, String> desensitizer() {
        return null;
    }
}

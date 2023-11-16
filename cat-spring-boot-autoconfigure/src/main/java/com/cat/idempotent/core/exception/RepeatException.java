package com.cat.idempotent.core.exception;

/**
 * @author _qiu
 */
public class RepeatException extends RuntimeException {
    public RepeatException(String message) {
        super(message);
    }
}

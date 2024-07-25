package com.cat.json;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author _qiu
 */
public enum ObjectMapperInstance {

    INSTANCE;

    private final ObjectMapper objectMapper = new ObjectMapper();

    ObjectMapperInstance() {

    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }
}
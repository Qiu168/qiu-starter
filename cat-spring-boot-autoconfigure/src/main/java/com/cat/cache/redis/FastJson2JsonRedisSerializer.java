package com.cat.cache.redis;


import com.alibaba.fastjson2.JSON;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author qiu
 */
public class FastJson2JsonRedisSerializer implements RedisSerializer {
    public static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;


    //private Class<Object> clazz;

    public FastJson2JsonRedisSerializer(Class<Object> clazz) {
        super();
        //this.clazz = clazz;
    }

    @Override
    public byte[] serialize(Object t) throws SerializationException {
        if (t == null) {
            return new byte[0];
        }
        return JSON.toJSONString(t).getBytes(DEFAULT_CHARSET);
    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        String str = new String(bytes, DEFAULT_CHARSET);

        return str;
    }
}

package com.cat.cache.redis;

import com.alibaba.fastjson2.JSON;
import org.springframework.data.redis.core.RedisTemplate;


/**
 * 存obj，自动转化成json字符串，取出来是json字符串<p>
 * 如果你觉得可以取出来时自动转换就帮我优化吧
 * @author _qiu
 */
public class JsonRedisTemplate<K,V> extends RedisTemplate<K,V> {
    public <T> T getJsonObj(String key, Class<T> cls) {
        return JSON.parseObject((String) super.opsForValue().get(key),cls);
        //return BeanUtil.mapToBean((Map) super.opsForValue().get(key),cls,false,null);
    }
}

package com.cat.cache.redis;

import org.springframework.data.redis.connection.BitFieldSubCommands;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.ValueOperations;

import java.time.Duration;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * todo
 * @author _qiu
 */
public class JsonValueOperations<K,V> implements ValueOperations<K, V> {

    @Override
    public void set(K key, V value) {
        //set(key,value,);
    }

    @Override
    public void set(K key, V value, long timeout, TimeUnit unit) {

    }

    @Override
    public Boolean setIfAbsent(K key, V value) {
        return null;
    }

    @Override
    public Boolean setIfAbsent(K key, V value, long timeout, TimeUnit unit) {
        return null;
    }

    @Override
    public Boolean setIfPresent(K key, V value) {
        return null;
    }

    @Override
    public Boolean setIfPresent(K key, V value, long timeout, TimeUnit unit) {
        return null;
    }

    @Override
    public void multiSet(Map<? extends K, ? extends V> map) {

    }

    @Override
    public Boolean multiSetIfAbsent(Map<? extends K, ? extends V> map) {
        return null;
    }

    @Override
    public V get(Object key) {
        return null;
    }

    @Override
    public V getAndDelete(K key) {
        return null;
    }

    @Override
    public V getAndExpire(K key, long timeout, TimeUnit unit) {
        return null;
    }

    @Override
    public V getAndExpire(K key, Duration timeout) {
        return null;
    }

    @Override
    public V getAndPersist(K key) {
        return null;
    }

    @Override
    public V getAndSet(K key, V value) {
        return null;
    }

    @Override
    public List<V> multiGet(Collection<K> keys) {
        return null;
    }

    @Override
    public Long increment(K key) {
        return null;
    }

    @Override
    public Long increment(K key, long delta) {
        return null;
    }

    @Override
    public Double increment(K key, double delta) {
        return null;
    }

    @Override
    public Long decrement(K key) {
        return null;
    }

    @Override
    public Long decrement(K key, long delta) {
        return null;
    }

    @Override
    public Integer append(K key, String value) {
        return null;
    }

    @Override
    public String get(K key, long start, long end) {
        return null;
    }

    @Override
    public void set(K key, V value, long offset) {

    }

    @Override
    public Long size(K key) {
        return null;
    }

    @Override
    public Boolean setBit(K key, long offset, boolean value) {
        return null;
    }

    @Override
    public Boolean getBit(K key, long offset) {
        return null;
    }

    @Override
    public List<Long> bitField(K key, BitFieldSubCommands subCommands) {
        return null;
    }

    @Override
    public RedisOperations<K, V> getOperations() {
        return null;
    }
}

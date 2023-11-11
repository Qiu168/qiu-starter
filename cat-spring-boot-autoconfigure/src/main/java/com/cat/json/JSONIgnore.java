package com.cat.json;

import com.alibaba.fastjson2.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 模仿{@link com.fasterxml.jackson.annotation.JsonIgnore JsonIgnore}
 * 此处是fastjson的JSONIgnore
 * 区别就是fastjson喜欢用JSON
 * 不影响反序列化，maybe
 * @author _qiu
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@JsonIgnore
@JSONField(serialize = false)
public @interface JSONIgnore {
}
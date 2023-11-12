package com.cat.json;

import com.alibaba.fastjson2.annotation.JSONField;
import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 给喜欢用fastjson，springmvc又用默认json的人用的 <p>
 * 模仿{@link com.fasterxml.jackson.annotation.JsonIgnore JsonIgnore} <p>
 * 此处是fastjson的JSONIgnore <p>
 * 区别就是fastjson喜欢用JSON <p>
 * 不影响反序列化，maybe <p>
 * @author _qiu
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@JsonIgnore
@JacksonAnnotationsInside
@JSONField(serialize = false)
public @interface JSONIgnore {
}
package com.cat.valid;

import javax.annotation.processing.ProcessingEnvironment;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * 这是一个编译时注解，用来放到接口上，继承此接口的实现类必须是ENUM <p>
 * 很遗憾这似乎是不能晇包的，因为他是一个一个包编译的。<p></p>
 * 因为编译器不会从头到尾编译全部内容，似乎只会编译修改的。如果执意执行：(报错后再次执行)该注解无法检测 <p></p>
 * todo
 *  我已试过将这个注解抽取出来单独放一个模块，但是A包定义的注解，B包实现无法检查
 * 可以手动加
 * @see MustBeEnumProcessor#init(ProcessingEnvironment)
 * @author _qiu
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.TYPE)
public @interface MustBeEnum {
}

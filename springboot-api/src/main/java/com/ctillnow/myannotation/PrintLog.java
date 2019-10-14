package com.ctillnow.myannotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by caiping on 2019/10/12.
 */

@Target({ElementType.METHOD,ElementType.TYPE})  //定义注解修饰的目标 类，方法。。。
@Retention(RetentionPolicy.RUNTIME)  //定义注解生命周期
@Documented
public @interface PrintLog {
    String value() default  "";


}

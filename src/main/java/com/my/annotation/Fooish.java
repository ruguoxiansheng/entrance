package com.my.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.TYPE, ElementType.METHOD }) //可以用在方法或者类上面
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Fooish {
	
	String[] tags() default { "all" };
}

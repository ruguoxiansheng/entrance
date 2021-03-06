package myAnnotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Component;

/**
 * 定义了一个扫描的，如果有Component注解，那么这个注解就会自动扫描
 * 注解的类
 * @author by_wwj
 *
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface MyAnnotation {

	String value() default "";
}

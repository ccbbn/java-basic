package chap06.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Anno {
    // element
    // [type] [element]
    // type : primitive, String, Enum, Class, Array
    String value() default "-";
    int number() default 15;


}

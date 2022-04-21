package com.amei.knowledge.annotion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface BusinessType {
    String value() default "";
    boolean excuteInit() default false;
    boolean defaultCategory() default false;
}

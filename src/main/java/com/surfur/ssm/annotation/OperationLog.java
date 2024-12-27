package com.surfur.ssm.annotation;

import com.surfur.ssm.common.LogScheme;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface OperationLog {

    LogScheme.OperationType type();

    String target() default "";

    String content() default "";


}

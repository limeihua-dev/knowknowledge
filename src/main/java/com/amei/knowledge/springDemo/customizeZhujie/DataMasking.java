package com.amei.knowledge.springDemo.customizeZhujie;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@interface DataMasking {

    DataMaskingFunc maskFunc() default DataMaskingFunc.NO_MASK;

}

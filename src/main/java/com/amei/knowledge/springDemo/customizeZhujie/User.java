package com.amei.knowledge.springDemo.customizeZhujie;

import java.io.Serializable;

public class User implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 姓名
     */
    @DataMasking(maskFunc = DataMaskingFunc.ALL_MASK)
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 邮箱
     */
    @DataMasking(maskFunc = DataMaskingFunc.ALL_MASK)
    private String email;

}

package com.amei.knowledge.springDemo.customizeZhujie;

public interface DataMaskingOperation {

    String MASK_CHAR = "*";

    String mask(String content, String maskChar);

}

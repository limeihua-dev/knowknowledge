package com.amei.knowledge.test;

import java.math.BigDecimal;

public class spring三级缓存debug测试 {
    public static void main(String[] args) {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        context.getBean("a",A.class);
//        context.getBean("b", B.class);
        BigDecimal bigDecimal = new BigDecimal(10);
        BigDecimal bigDecimal2 = new BigDecimal(3);
        bigDecimal.divide(bigDecimal2);

    }
}

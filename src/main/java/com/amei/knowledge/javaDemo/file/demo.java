package com.amei.knowledge.javaDemo.file;

import java.io.File;

public class demo {
    public static void main(String[] args) {
//        String s = demo.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "/";
//        System.out.println(s);
        File file = new File(System.getProperties().getProperty("user.home")+File.separator+"ns");
        boolean mkdir = file.mkdir();
        System.out.println(mkdir);
        System.out.println(System.getProperties().getProperty("user.home")+File.separator+"ns");
        System.out.println(new File("/Users/meihua/ns/business_model/123123/from/").mkdirs());
    }
}

package com.amei.knowledge.test;

public class streamBufferTest {
    public static void main(String[] args) {
        String str = new StringBuilder("58").append("tongcheng").toString();
        System.out.println(str);
        System.out.println(str.intern());
        System.out.println(str == str.intern());
    }
}

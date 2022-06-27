package com.amei.knowledge.test;

public class TestConstant {
    public static void main(String[] args) {
        final byte b1=1;
        final byte b2=3;
         byte b3=b1+b2;//当程序执行到这一行的时候会出错，因为b1、b2可以自动转换成int类型的变量，运算时java虚拟机对它进行了转换，结果导致把一个int赋值给byte-----出错

    }
}

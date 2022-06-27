package com.amei.knowledge.test;

import java.util.Random;

public class Test2 {
    //编译期常量
    final int i = 1;
    final static int J = 1;
    final int[] a = {1, 2, 3, 4};
    //非编译期常量
    Random r = new Random();
    final int k = r.nextInt();

    public static void main(String[] args) {

    }
}

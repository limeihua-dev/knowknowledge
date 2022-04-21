package com.amei.knowledge.javaDemo.streamAnd函数编程;

import java.util.stream.IntStream;

/*
 * 比较stream与parallelStream的运行速度
 */
public class stream与parallelStream {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        //初始化一个范围100万整数流,求能被2整除的数字，toArray()是终点方法
        int a[] = IntStream.range(0, 1_000_000).filter(p -> p % 2 == 0).toArray();
        long endTime = System.nanoTime();
        int b[]=IntStream.range(0, 1_000_000).parallel().filter(p -> p % 2==0).toArray();
        long t2 = System.nanoTime();
        //serial: 0.07s, parallel 0.03s
        System.out.printf("serial: %.2fs, parallel %.2fs%n", (endTime - startTime) * 1e-9, (t2 - endTime) * 1e-9);
    }
}

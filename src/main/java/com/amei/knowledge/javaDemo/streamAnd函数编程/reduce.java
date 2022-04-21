package com.amei.knowledge.javaDemo.streamAnd函数编程;

import java.util.Arrays;
import java.util.List;

/*
* reduce 、用法
* */
public class reduce {
    public static void main(String[] args) {
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        double bill = costBeforeTax.stream().map((cost) -> cost + 0.12*cost).reduce((sum, cost) -> sum + cost).get();
        System.out.println("Total : " + bill);

    }
}

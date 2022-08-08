package com.amei.knowledge.thread;

import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

public class LongAdderDemo {
    public static void main(String[] args) {
        //只能用来计算加法，且从0开始计算
        LongAdder longAdder = new LongAdder();
        longAdder.increment();
        longAdder.increment();
        longAdder.increment();
        long sum = longAdder.sum();
        System.out.println(sum);

        //x是初始值，y是传进来的值
        LongAccumulator longAccumulator = new LongAccumulator((x,y)->x+y,0);
        longAccumulator.accumulate(1);
        longAccumulator.accumulate(3);
        System.out.println(longAccumulator.get());
    }
}

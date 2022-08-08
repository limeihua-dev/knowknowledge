package com.amei.knowledge.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

class ClickNumber {
    int number = 0;
    LongAdder longAdder = new LongAdder();
    AtomicLong atomicLong = new AtomicLong(0);
    LongAccumulator longAccumulator = new LongAccumulator((x, y) -> x + y, 0);
    public synchronized void clickBySynchronized() {
        number++;
    }
    public void clickByAtomicLong() {
        atomicLong.getAndIncrement();
    }
    public void clickByLongAdder() {
        longAdder.increment();
    }
    public void clickBylongAccumulator() {
        longAccumulator.accumulate(1);
    }
}

/**
 * 50个线程，每个线程100w次，计算总点赞数
 */
public class AccumulatorCompareDemo {
    private static final int _1w = 10000;
    private static final int threadNumber = 50;

    public static void main(String[] args) throws InterruptedException {
        ClickNumber clickNumber = new ClickNumber();
        long startTime;
        long endTime;
        CountDownLatch countDownLatch1 = new CountDownLatch(threadNumber);
        CountDownLatch countDownLatch2 = new CountDownLatch(threadNumber);
        CountDownLatch countDownLatch3 = new CountDownLatch(threadNumber);
        CountDownLatch countDownLatch4 = new CountDownLatch(threadNumber);
        startTime = System.currentTimeMillis();
        for (int i = 0; i < threadNumber; i++) {
            new Thread(() -> {
                try {
                    for (int j = 0; j < 100 * _1w; j++) {
                        //用时：2222、919、189、238ms
//                        clickNumber.clickBySynchronized();
//                        clickNumber.clickByAtomicLong();
//                        clickNumber.clickByLongAdder();
                        clickNumber.clickBylongAccumulator();
                    }
                } finally {
//                    countDownLatch1.countDown();
//                    countDownLatch2.countDown();
//                    countDownLatch3.countDown();
                    countDownLatch4.countDown();
                }
            }, String.valueOf(i)).start();
        }
//        countDownLatch1.await();
//        countDownLatch2.await();
//        countDownLatch3.await();
        countDownLatch4.await();
        endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime));
//        System.out.println(clickNumber.number);//2222、919、189、238
//        System.out.println(clickNumber.atomicLong.get());
        System.out.println(clickNumber.longAccumulator.get());
    }
}

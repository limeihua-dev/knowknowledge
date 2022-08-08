package com.amei.knowledge.thread;

import lombok.Data;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Data
class House {
    //    ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
//        @Override
//        protected Integer initialValue() {
//            return 0;
//        }
//    };
    //推荐使用
    ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);
     int saleCount = 0;

    public void saleHouse() {
        saleCount++;
        Integer integer = threadLocal.get();
        integer++;
        threadLocal.set(integer);
    }

}

public class ThreadLocalDemo {
    public static void main(String[] args) throws InterruptedException {
        ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);
        House house = new House();
        for (int j = 0; j < 5; j++) {
            new Thread(() -> {
                try {
                    int nextInt = new Random().nextInt(13);
                    for (int i = 1; i <= nextInt; i++) {
                        house.saleHouse();
                    }
                    System.out.println(Thread.currentThread().getName() + "\t" + "-- - 卖出:" + house.threadLocal.get());
                } finally {
                    house.threadLocal.remove();
                }
            }, String.valueOf(j)).start();
        }
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println(Thread.currentThread().getName() + "\t" + "-- - 卖出:" + house.saleCount);
        ThreadLocal<Object> objectThreadLocal = new ThreadLocal<>();
        objectThreadLocal.set(null);
    }
}



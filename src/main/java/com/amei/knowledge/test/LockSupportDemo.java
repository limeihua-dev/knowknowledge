package com.amei.knowledge.test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo {
    public static void main(String[] args) {
        lockSupport();
    }
    private static void lockSupport() {
        Thread a = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " come in");
            try {
                TimeUnit.SECONDS.sleep(3L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + " 被唤醒");
        }, "a");
        a.start();
        //  暂停3s线程
//        try {
//            TimeUnit.SECONDS.sleep(1L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Thread b = new Thread(() -> {
            LockSupport.unpark(a);
            System.out.println(Thread.currentThread().getName() + " 通知");
        }, "b");
        b.start();
    }
}

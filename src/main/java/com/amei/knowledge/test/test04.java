package com.amei.knowledge.test;

import java.util.concurrent.TimeUnit;

public class test04 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("----- isInterrupted() =true，程序结束");
                    break;
                }
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();//二次调用
                    e.printStackTrace();
                }
                System.out.println("-------------- hello isStop");
            }
        }, "t1");
        t1.start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            t1.interrupt();
        }, "t2").start();
    }
}

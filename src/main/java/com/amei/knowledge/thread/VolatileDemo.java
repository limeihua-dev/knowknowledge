package com.amei.knowledge.thread;

import java.util.concurrent.TimeUnit;

public class VolatileDemo {
    static volatile boolean flag = true;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (flag) {

            }
        }, "t1");
        t1.start();
        try {
            TimeUnit.MILLISECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = false;
        System.out.println("flag修改完成...");
    }
}

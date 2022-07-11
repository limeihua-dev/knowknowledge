package com.amei.knowledge.test;


public class ObjectWaitTest {
    public static void main(String[] args) {
        Object objectLock = new Object();
        new Thread(() -> {
            System.out.println("t1 come in");
            synchronized (objectLock) {
                try {
                    objectLock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t1 被唤醒");
            }
        }, "t1").start();
        new Thread(() -> {
            System.out.println("t2 come in");
            synchronized (objectLock) {
                objectLock.notify();
                System.out.println("t2 唤醒其他线程");
            }
        }, "t2").start();
    }
}

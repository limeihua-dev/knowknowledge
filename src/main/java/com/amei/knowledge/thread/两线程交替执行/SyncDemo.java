package com.amei.knowledge.thread.两线程交替执行;

public class SyncDemo {
    public static void main(String[] args) {
        final Object obj = new Object();
        char[] aI = "1234567".toCharArray();
        char[] aC = "abcdefg".toCharArray();

        new Thread(() -> {
            synchronized (obj) {
                for (char c : aI) {
                    System.out.print(c);
                    try {
                        obj.notify();//叫醒的是另外一个线程
                        obj.wait();//当前线程  让出锁 ，当前线程自己阻塞
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                obj.notify();//必须，否则无法停止程序，因为总有一个线程是不能被中止的； A唤醒B，A阻塞自己；B唤醒A,A阻塞自己
            }
        }, "t1").start();

        new Thread(() -> {
            synchronized (obj) {
                for (char c : aC) {
                    System.out.print(c);
                    try {
                        obj.notify();
                        obj.wait();//让出锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                obj.notify();
            }
        }, "t2").start();
    }
}

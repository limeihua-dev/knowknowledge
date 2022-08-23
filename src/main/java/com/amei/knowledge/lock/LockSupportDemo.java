package com.amei.knowledge.lock;

import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            LockSupport.park();//被阻塞，等待通知，当前凭证只有一个可以消耗
            LockSupport.park();//被阻塞，当前没有凭证可以消耗，无法被通知，
            System.out.println("当前线程：" + Thread.currentThread());
        }, "t1");
        t1.start();

        new Thread(() -> {
            LockSupport.unpark(t1);//唤醒通知
            LockSupport.unpark(t1);//唤醒通知，凭证最多累加到1
        }, "t2").start();
    }
}

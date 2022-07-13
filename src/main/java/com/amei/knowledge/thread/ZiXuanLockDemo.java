package com.amei.knowledge.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 实现自旋锁，使用CAS原理
 */
public class ZiXuanLockDemo {
    AtomicReference<Thread> atomicReference = new AtomicReference<Thread>();

    public void lock() {
        System.out.println(Thread.currentThread().getName() + "\t" + " .....lock");
        Thread thread = Thread.currentThread();
        while (!atomicReference.compareAndSet(null, thread)) {

        }
    }

    public void unLock() {
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread, null);
        System.out.println(Thread.currentThread().getName() + "\t" + " .....unlock");
    }

    public static void main(String[] args) {
        ZiXuanLockDemo ziXuanLockDemo = new ZiXuanLockDemo();
        new Thread(() -> {
            ziXuanLockDemo.lock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ziXuanLockDemo.unLock();
        }, "t1").start();

        new Thread(() -> {
            ziXuanLockDemo.lock();
            ziXuanLockDemo.unLock();
        }, "t2").start();
    }
    //打印：
//    t1	 .....lock
//    t2	 .....lock
//    t1	 .....unlock
//    t2	 .....unlock
}

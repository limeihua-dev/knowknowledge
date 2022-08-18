package com.amei.knowledge.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 所谓重入锁，指的是以线程为单位，当一个线程获取对象锁之后，这个线程可以再次获取本对象上的锁，而其他的线程是不可以的。
 * 可重入就是说某个线程已经获得某个锁，可以再次获取锁而不会出现死锁。
 */
public class 可重入锁2 {
    public static void main(String[] args) {
        Lock reentrantLock = new ReentrantLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    reentrantLock.lock();
                    System.out.println("第一次获取锁，这个锁是：" + this);
                    int index = 1;
                    while (true) {
                        try {
                            reentrantLock.lock();
                            System.out.println("第" + index + "次获取锁，这个锁是：" + this);
                        } finally {
                            reentrantLock.unlock();
                        }
                        index++;
                        if (index == 10)
                            break;
                    }
                } finally {
                    reentrantLock.unlock();
                }
            }
        }, "t1").start();


//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                synchronized (this) {
//                    System.out.println("第一次获取锁，这个锁是：" + this);
//                    int index = 1;
//                    while (true) {
//                        synchronized (this) {
//                            System.out.println("第" + index + "次获取锁，这个锁是：" + this);
//                        }
//                        index++;
//                        if (index == 10)
//                            break;
//                    }
//                }
//            }
//        }, "t1").start();
    }
}

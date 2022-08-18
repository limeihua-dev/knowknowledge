package com.amei.knowledge.lock.不可重入锁;

/**
 * 产生死锁、必须先释放锁
 */
public class Count {
    public static void main(String[] args) throws InterruptedException {
        Lock lock = new Lock();
        lock.lock();
        lock.lock();
        //do something
        System.out.println("---");
        lock.unlock();
        lock.unlock();
    }
}

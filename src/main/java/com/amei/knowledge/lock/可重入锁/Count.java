package com.amei.knowledge.lock.可重入锁;

public class Count {
    public static void main(String[] args) throws InterruptedException {
        Lock lock = new Lock();
        lock.lock();
        lock.lock();
        //do something
        lock.unlock();
        lock.unlock();
    }
}

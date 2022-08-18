package com.amei.knowledge.lock.可重入锁;

public class Lock {

    private boolean isLock = false;
    Thread lockedBy = null;
    int lockedCount = 0;

    public synchronized void lock() throws InterruptedException {
        Thread thread = Thread.currentThread();
        System.out.println(lockedBy);
        while (isLock && lockedBy != thread) {
            wait();
        }
        lockedCount++;
        isLock = true;
        lockedBy = thread;
    }

    public synchronized void unlock() {
        System.out.println(this.lockedCount);
        if (Thread.currentThread() == this.lockedBy) {
            lockedCount--;
            if (lockedCount == 0) {
                isLock = false;
                notify();
            }
        }
    }
}


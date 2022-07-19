package com.amei.knowledge.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

class BankAccout {
    String bankName = "ccb";
    public volatile int money = 0;
    AtomicIntegerFieldUpdater FieldUpdater = AtomicIntegerFieldUpdater.newUpdater(BankAccout.class, "money");
    public void transfer(BankAccout bankAccout) {
        FieldUpdater.incrementAndGet(bankAccout);
    }
}

public class AtomicIntegerFieldUpdaterDemo {
    public static void main(String[] args) throws InterruptedException {
        BankAccout bankAccout = new BankAccout();
        int count = 1000;
        final CountDownLatch latch = new CountDownLatch(10);
        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                try {
                    for (int j = 0; j <1000 ; j++) {
                        bankAccout.transfer(bankAccout);
                    }
                } finally {
                    latch.countDown();
                }
            }, String.valueOf(i)).start();
        }
        latch.await();
        System.out.println(Thread.currentThread().getName() + "\t" + "------bankAccount:" + bankAccout.money);
    }
}

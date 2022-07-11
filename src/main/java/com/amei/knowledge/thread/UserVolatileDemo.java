package com.amei.knowledge.thread;

public class UserVolatileDemo {
    public class Counter {
        private volatile int value;

        public int getValue() {
            return value; //利用volatile保证读取操作的可见性
        }

        public synchronized int increment() {
            return value++;
        }
    }
}

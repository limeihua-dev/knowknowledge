package com.amei.knowledge.thread.两线程交替执行;

import java.util.concurrent.locks.LockSupport;

/**
 * 将数字与字母交替打印
 */
public class ParkDemo {
    static Thread t1 = null;
    static Thread t2 = null;

    public static void main(String[] args) {
        char[] aI = "1234567".toCharArray();
        char[] aC = "abcdefg".toCharArray();
        t1 = new Thread(() -> {
            for (char c : aI) {
                System.out.print(c);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        }, "t1");
        t2 = new Thread(() -> {
            for (char c : aC) {
                LockSupport.park();
                System.out.print(c);
                LockSupport.unpark(t1);
            }
        }, "t2");
        t1.start();
        t2.start();
    }
}

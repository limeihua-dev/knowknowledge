package com.amei.knowledge.设计模式.mode.singleMode;

/**
 * 线程安全
 */
public class LazySingleSafeDemo {
    private static LazySingleSafeDemo instance;

    private LazySingleSafeDemo() {
    }

    public static synchronized LazySingleSafeDemo getInstance() {
        if (instance == null) {
            instance = new LazySingleSafeDemo();
        }
        return instance;
    }
}

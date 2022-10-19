package com.amei.knowledge.设计模式.mode.singleMode;

/**
 * 饿汉
 * <p>
 * 缺点：系统初始化时会造成大量的内存浪费，从而导致系统内存不可控
 * 适用场景：饿汉式单例模式适用于单例对象较少的情况
 */
public class HungrySingletonDemo {

    private static HungrySingletonDemo instance = new HungrySingletonDemo();

    private HungrySingletonDemo() {
    }

    public static HungrySingletonDemo getInstance() {
        return instance;
    }
}

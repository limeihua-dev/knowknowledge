package com.amei.knowledge.设计模式.mode.singleMode;

import org.springframework.util.SerializationUtils;

import java.lang.reflect.Constructor;

public class HungrySingUnSafeDemo {
    private static HungrySingUnSafeDemo instance = new HungrySingUnSafeDemo();

    private HungrySingUnSafeDemo() {
    }

    public static HungrySingUnSafeDemo getInstance() {
        return instance;
    }

    public static void main(String[] args) throws Exception {
        HungrySingUnSafeDemo instance = HungrySingUnSafeDemo.getInstance();
        Constructor<HungrySingUnSafeDemo> declaredConstructor = HungrySingUnSafeDemo.class.getDeclaredConstructor();
        HungrySingUnSafeDemo lazySingletonSafeDemo = declaredConstructor.newInstance();
        System.out.println("instance==lazySingletonSafeDemo:  " + (instance == lazySingletonSafeDemo));
        System.out.println(instance);
        System.out.println(lazySingletonSafeDemo);
        //序列化与反序列化
        byte[] serialize = SerializationUtils.serialize(instance);
        Object deserialize = SerializationUtils.deserialize(serialize);
        System.out.println("序列化与反序列化  " + (deserialize == serialize));
        System.out.println(serialize);
        System.out.println(deserialize);
    }
}

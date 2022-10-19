package com.amei.knowledge.设计模式.mode.singleMode;

/**
 * 单例模式（Singleton Pattern）：确保一个类有且只有一个实例，并提供一个全局访问点
 * 实现单例模式的最佳方法是使用枚举
 * <p>
 * 在开发中，很多时候有一些对象其实我们只需要一个，
 * 例如：线程池（threadpool）、缓存（cache）、默认设置、注册表（registry）、日志对象等等，这个时候把它设计为单例模式是最好的选择
 * <p>
 * 优点：
 * 1、反射安全
 * 2、序列化/反序列化安全
 * 3、写法简单
 * 4、没有一个更有信服力的原因不去使用枚举
 */
public class EnumSingletonDemo {

    //私有化构造器
    private EnumSingletonDemo() {

    }

    //使用枚举
    private static enum Singleton {
        INSTANCE;
        private EnumSingletonDemo singleton;

        private Singleton() {
            singleton = new EnumSingletonDemo();
        }

        public EnumSingletonDemo getSingleton() {
            return singleton;
        }
    }

    //静态工程方法
    public static EnumSingletonDemo getInstance() {
        return Singleton.INSTANCE.getSingleton();
    }

}

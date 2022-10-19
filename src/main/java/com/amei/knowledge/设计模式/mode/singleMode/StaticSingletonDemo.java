package com.amei.knowledge.设计模式.mode.singleMode;

/**
 * 静态内部类<推荐></>
 * <p>
 * 达到了懒加载的效果：StaticSingletonDemo类被装载了而不会被立马初始化
 */
public class StaticSingletonDemo {

    private StaticSingletonDemo() {
    }

    private static class StaticSingletonDemoHandler {
        private static StaticSingletonDemo instance = new StaticSingletonDemo();
    }

    public static final StaticSingletonDemo getInstance() {
        return StaticSingletonDemoHandler.instance;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}

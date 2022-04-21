package com.amei.knowledge.javaDemo.streamAnd函数编程;

public class 自定义函数接口 {

    @FunctionalInterface
    public interface IMyInterface {
        void study();
    }

    public static void main(String[] args) {
        IMyInterface iMyInterface = () -> System.out.println("I like study");
        iMyInterface.study();
    }

}

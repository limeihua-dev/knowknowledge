package com.amei.knowledge.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        //创建任务
        Runnable task1 = new Task();
        Runnable task2 = new Task();
        Runnable task3 = new Task();
        //创建只有一个线程的线程池
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        //提交任务
        threadPool.execute(task1);
        threadPool.execute(task2);
        threadPool.execute(task3);
        //关闭线程池
        threadPool.shutdown();
//        String s = String.valueOf();
        task3.toString();
        //打印
//        pool-1-thread-1
//        pool-1-thread-1
//        pool-1-thread-1
    }
}

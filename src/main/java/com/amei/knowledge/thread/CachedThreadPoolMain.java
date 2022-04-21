package com.amei.knowledge.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolMain {
    public static void main(String[] args) {
        // 创建任务
        Task task1 = new Task();
        Task task2 = new Task();
        Task task3 = new Task();
        // 创建可缓存的线程池
        ExecutorService threadPool = Executors.newCachedThreadPool();
        //提交任务
        threadPool.execute(task1);
        threadPool.execute(task2);
        threadPool.execute(task3);
        //关闭线程池
        threadPool.shutdown();
        //打印
//        pool-1-thread-1
//        pool-1-thread-3
//        pool-1-thread-2
    }
}

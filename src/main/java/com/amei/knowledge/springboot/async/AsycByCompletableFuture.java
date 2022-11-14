package com.amei.knowledge.springboot.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsycByCompletableFuture {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("主线程 =====> 开始 =====> " + System.currentTimeMillis());
        ExecutorService executor = Executors.newSingleThreadExecutor();
        CompletableFuture.runAsync(() -> {
            System.out.println("异步线程 =====> 开始 =====> " + System.currentTimeMillis());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("异步线程 =====> 结束 =====> " + System.currentTimeMillis());
        }, executor);
        executor.shutdown();//回收线程池
        Thread.sleep(2000);
        System.out.println("主线程 =====> 结束 =====> " + System.currentTimeMillis());
    }
}

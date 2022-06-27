package com.amei.knowledge.thread;

import java.util.concurrent.*;

public class MyFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(new MyThread());
        new Thread(futureTask, "t1").start();
//        System.out.println(futureTask.get());
        while (true) {
            if (futureTask.isDone()) {
                break;
            } else {
                System.out.println("任务正在进行中");
            }
        }
    }

    public static class MyThread implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println("into Callable");
            return "hello";
        }
    }

    public class myThread2 implements Runnable {
        @Override
        public void run() {
        }
    }
}

package com.amei.knowledge.springboot.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Future;

/**
 * 其中 org.springframework.scheduling.annotation.AsyncResult
 * 实现了 java.util.concurrent.Future 接口，并增加了一些额外有用的功能
 */
@Component
public class AsyncTask {
    Logger log = LoggerFactory.getLogger(AsyncTask.class);

    private Random random = new Random();

    /**
     * 定义三个异步式方法
     *
     * @throws InterruptedException
     */
    @Async
    public Future<String> taskOne() throws InterruptedException {
        long start = System.currentTimeMillis();
        //随机休眠若干毫秒
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        log.info("任务一执行完成耗时{}秒", (end - start) / 1000f);
        return new AsyncResult<>("任务一完事了");
    }

    @Async
    public Future<String> task2() throws InterruptedException {
        long start = System.currentTimeMillis();
        //随机休眠若干毫秒
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        log.info("任务2执行完成耗时{}秒", (end - start) / 1000f);
        return new AsyncResult<>("任务2完事了");
    }

    @Async
    public Future<String> task3() throws InterruptedException {
        long start = System.currentTimeMillis();
        //随机休眠若干毫秒
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        log.info("任务3执行完成耗时{}秒", (end - start) / 1000f);
        return new AsyncResult<>("任务3完事了");
    }

}

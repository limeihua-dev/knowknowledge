package com.amei.knowledge.springboot.async.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableAsync
public class SelfAsyncConfig {

    @Bean(name = "selfConfigThreadPool")
    public ExecutorService threadPoolTaskExecutor() {
        /**
         * corePoolSize: 线程池中至少有多少个线程，即使没有任何任务需要执行的情况下仍然需要保留
         * maximumPoolSize：线程池中最多有多少个线程
         * keepAliveTime：除了 corePoolSize 数量的线程，其他线程最大的空闲时间，超过空闲时间后会被回收
         * unit：keepAliveTime 的时间单位，毫秒，秒等
         * workQueue：等待执行任务的队列，里面的对象需要实现 Runnable 或者 Callable 接口
         */
        return new ThreadPoolExecutor(1, 1,
                60L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>());
    }
}

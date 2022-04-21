package com.amei.knowledge.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomThreadFactory implements ThreadFactory {

    /**
     * 计数器
     */
    private AtomicInteger atomicInteger = new AtomicInteger(1);

    @Override
    public Thread newThread(Runnable r) {

        //创建线程，并指定任务
        Thread thread = new Thread(r);
        //设置线程名称
        thread.setName("线程" + atomicInteger + " 号");
        return null;
    }
}

package com.amei.knowledge.springboot.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
public class AsyncMethodTask {
    Logger logger = LoggerFactory.getLogger(AsyncMethodTask.class);
    /**
     * 异步执行不带返回值
     *
     * @param a
     */
    @Async
    public void asyncMethodTaskWithVoidReturnType(String a) {
        System.out.println("异步线程 =====> 开始 =====> " + System.currentTimeMillis());
        //Thread.Sleep会阻塞线程，这样运行在该线程下的所有协程都会被阻塞
        System.out.println(111);
        try {
            Thread.sleep(1000);
            System.out.println(222);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(333);
        System.out.println(Thread.currentThread().getName());
        logger.info("Execute method asynchronously, thread name = {}", Thread.currentThread().getName());
        System.out.println("异步无返回值方法： " + a + "  -    " + Thread.currentThread().getName());
        System.out.println("异步线程 =====> 结束 =====> " + System.currentTimeMillis());
    }

    /**
     * 有返回值的异步方法
     *
     * @return
     * @Async也可以应用有返回值的方法–通过在Future中包装实际的返回值：
     */
    @Async
    public Future<String> asyncMethodWithReturnType() {
        System.out.println("执行有返回值的异步方法 "
                + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
            return new AsyncResult<String>("hello world !!!!");
        } catch (InterruptedException e) {
            //
        }
        return null;
    }
}

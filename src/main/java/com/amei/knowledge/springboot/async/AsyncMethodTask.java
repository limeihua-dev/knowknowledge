package com.amei.knowledge.springboot.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
public class AsyncMethodTask {
    @Async
    public void asyncMethodTaskWithVoidReturnType(String a) {
        //Thread.Sleep会阻塞线程，这样运行在该线程下的所有协程都会被阻塞
        //delay?9)
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        int i = 1 / 0;
        System.out.println("异步无返回值方法： " + a + "  -    " + Thread.currentThread().getName());
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

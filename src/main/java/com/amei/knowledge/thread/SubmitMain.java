package com.amei.knowledge.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SubmitMain {
    public static void main(String[] args) throws Exception {
        //创建任务
        ImplementCallableThread thread = new ImplementCallableThread();
        Task task = new Task();
        //创建线程池
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        //submit方式提交任务
        Future<Integer> submit = threadPool.submit(thread);
        //submit此时不会抛出异常
        //execute提交任务
        threadPool.execute(task);
        //输出任务执行结果
        //        Integer integer = submit.get();
        //        System.out.println(333);
        //        System.out.println(integer);//2
        //        thread.call();
        //关闭线程池
        threadPool.shutdown();

        //区别1： submit方式有返回值:Future、execute方式没有返回值
        //区别2： execute()在执行任务时，如果遇到异常会直接抛出;submit()不会直接抛出，只有在使用Future#get方法获取返回值时，才会抛出异常。

    }
}

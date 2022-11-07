package com.amei.knowledge;

import com.amei.knowledge.springboot.async.AsyncTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Author 三分恶
 * @Date 2020/7/15
 * @Description
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AsyncTaskTest {

    @Autowired
    private AsyncTask asyncTask;

    Logger log= LoggerFactory.getLogger(AsyncTaskTest.class);

    @Test
    public void doAsyncTasks(){
        try {
            long start = System.currentTimeMillis();
            //调用三个异步式方法
            asyncTask.taskOne();
            asyncTask.task2();
            asyncTask.task3();
            Thread.sleep(5000);
            long end = System.currentTimeMillis();
            log.info("主程序执行完成耗时{}秒", (end - start)/1000f);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void doFutureTask2(){
        try {
            long start=System.currentTimeMillis();
            Future<String> future1=asyncTask.taskOne();
            Future <String> future2 = asyncTask.task2();
            Future <String> future3 = asyncTask.task3();
            //三个任务执行完再执行主程序
            do {
                Thread.sleep(100);
            } while (future1.isDone() && future2.isDone() && future3.isDone());
            log.info("获取异步方法的返回值:{}", future3.get());
            Thread.sleep(5000);
            long end = System.currentTimeMillis();
            log.info("主程序执行完成耗时{}秒", (end - start)/1000f);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

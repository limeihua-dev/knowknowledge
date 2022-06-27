package com.amei.knowledge.thread;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 可用于多线程计算数据，最后合并计算结果
 * 1、一个线程组的线程需要等待所有线程完成任务再执行下一次任务
 */
public class CyclicBarrierTest {
    private static Random random = new Random();

    public static void execute(CyclicBarrier cyclicBarrier) {
        //获取一个随机数
        int sleepTime = random.nextInt(10);
        long threadId = Thread.currentThread().getId();
        try {
            Thread.sleep(sleepTime * 10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程ID" + threadId + ",准备任务完成耗时：" + sleepTime + "当前时间" + System.currentTimeMillis());

        //线程被阻塞，等待其他任务完成后唤醒
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("线程ID: " + threadId + " 开始执行任务，当前时间：" + System.currentTimeMillis());
    }

    public static void main(String[] args) {
        //初始化线程数量
        int threadNum = 10;
        //parties: 参与线程的个数
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () -> System.out.println("整理任务开始..."));
        ExecutorService executor = Executors.newFixedThreadPool(threadNum);
        for (int i = 0; i < threadNum; i++) {
            executor.submit(() -> {
                execute(cyclicBarrier);
            });
        }
    }
}

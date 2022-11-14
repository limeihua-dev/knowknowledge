package com.amei.knowledge.thread;

/**
 * 现在有T1、T2、T3三个线程，你怎样保证T2在T1执行完后执行，T3在T2执行完后执行？
 * <p>
 * 使用join ,等待这个线程结束；也就是说t.join()方法阻塞调用此方法的线程阻塞，直到线程t完成，此线程再继续；
 */
public class ThreadJoinDemo {
    public static void main(String[] args) {
        //初始化线程1，由于后
        Thread thread1 = new Thread(() -> {
            System.out.println("t1 is running");
        }, "t1");
        //初始化线程2
        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                thread1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("t2 is running");
            }
        }, "t2");

        //初始化线程3
        Thread thread3 = new Thread(() -> {
            try {
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("t3 is running");
            }
        }, "t2");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

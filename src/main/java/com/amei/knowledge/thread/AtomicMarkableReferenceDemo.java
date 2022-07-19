package com.amei.knowledge.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicMarkableReference;

public class AtomicMarkableReferenceDemo {
    static AtomicMarkableReference markableReference = new AtomicMarkableReference(100, false);
    public static void main(String[] args) {
        new Thread(() -> {
            boolean marked = markableReference.isMarked();
            System.out.println("默认标识：\t" + marked);
            //等待t2线程和t1线程拿到一样的flag标识，都是false
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            markableReference.compareAndSet(100, 1000, marked, !marked);
        }, "t1").start();
        new Thread(() -> {
            boolean marked = markableReference.isMarked();
            System.out.println("默认标识：\t" + marked);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean b = markableReference.compareAndSet(100, 2000, marked, !marked);
            System.out.println(Thread.currentThread().getName() + "\t" + "t2 result:" + b);
            System.out.println(Thread.currentThread().getName() + "\t" + markableReference.isMarked());
            System.out.println(Thread.currentThread().getName() + "\t" + markableReference.getReference());
        }, "t2").start();
        /**
         * 执行结果：
         * 默认标识：	false
         * 默认标识：	false
         * t2	t2 result:false
         * t2	true
         * t2	1000
         */
    }
}

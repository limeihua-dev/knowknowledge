package com.amei.knowledge.test;

import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class test6 {
    public static void main(String[] args) {
        List<Integer> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(Integer.valueOf(i));
        }

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                ListIterator<Integer> iterator = list.listIterator();
                while (iterator.hasNext()) {
                    System.out.println("thread1 " + iterator.next().intValue());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (Integer integer : list) {
                    System.out.println("thread2 " + integer.intValue());
                    if (integer.intValue() == 5) {
                        list.remove(integer);
                    }
                }
                for (Integer integer : list) {
                    System.out.println("thread2 again " + integer.intValue());
                }
//                ListIterator<Integer> iterator = list.listIterator();
//                while (iterator.hasNext()) {
//                    Integer integer = iterator.next();
//                    System.out.println("thread2 " + integer.intValue());
//                    if (integer.intValue() == 5) {
//                        iterator.remove();
//                    }
//                }
            }
        });
        thread1.start();
        thread2.start();
    }
}

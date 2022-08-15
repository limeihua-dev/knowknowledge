package com.amei.knowledge.test;

import java.util.ArrayList;
import java.util.ListIterator;

public class test4 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            arrayList.add(Integer.valueOf(i));
        }

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                ListIterator<Integer> iterator = arrayList.listIterator();
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
                ListIterator<Integer> iterator = arrayList.listIterator();
                while (iterator.hasNext()) {
                    System.out.println("thread2 " + iterator.next().intValue());
                    iterator.remove();
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}

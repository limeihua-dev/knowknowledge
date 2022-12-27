package com.amei.knowledge.thread.两线程交替执行;

/**
 * 将数字与字母交替打印
 */
public class CycleDemo {

    enum ReadyToRun {T1, T2}


    static volatile ReadyToRun r = ReadyToRun.T2;

    public static void main(String[] args) {
        char[] aI = "1234567".toCharArray();
        char[] aC = "abcdefg".toCharArray();

        new Thread(() -> {
            for (char c : aI) {
                while (r == ReadyToRun.T1) {
                }
                System.out.print(c);
                r = ReadyToRun.T1;
            }
        }, "t1").start();

        new Thread(() -> {
            for (char c : aC) {
                while (r == ReadyToRun.T2) {
                }
                System.out.print(c);
                r = ReadyToRun.T2;
            }
        }, "t2").start();
    }

}

package com.amei.knowledge.test;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Function: 测试多线程下 改变Collection集合 对迭代器遍历造成的影响 Date: 2017年12月5日 下午9:58:53 <br/>
 *
 * @see
 */
public class IteratorListDelete {

    private final ArrayList<String> list;

    public IteratorListDelete(ArrayList<String> list) {
        super();
        this.list = list;
    }

    public ArrayList<String> getList() {
        return list;
    }

    public static void main(String[] args) {
        ArrayList<String> aList = new ArrayList<String>();
        IteratorListDelete tt = new IteratorListDelete(aList);
        for (int i = 0; i < 100; i++) {
            tt.getList().add(i + "");
        }
        new Thread(new TraverseList(tt), "子线程").start();
        // System.out.println(tt.getList().get(28));
        try {
            Thread.sleep(10);
            // tt.getList().remove(28+""); // 集合大小发生改变 ConcurrentModificationException
            tt.getList().add(101 + ""); // 集合大小发生改变 ConcurrentModificationException
            // tt.getList().set(28, 201+""); //改变集合内容，不会触发异常，因为没有改变Collection集合的大小
        } catch (InterruptedException e) {
            e.printStackTrace();

        }

    }

}

/**
 * ClassName: TraverseList <br/>
 * Function: 线程一直循环遍历collection集合 date: 2017年12月5日 下午10:35:06 <br/>
 */
class TraverseList implements Runnable {
    private final IteratorListDelete tt;

    public TraverseList(IteratorListDelete tt) {
        super();
        this.tt = tt;
    }

    public void run() {
        try {
            Thread.sleep(5);
        } catch (Exception e) {
            // TODO: handle exception
        }
        while (true) {
            Iterator<String> it = tt.getList().iterator();
            while (it.hasNext()) {
                System.out.println(Thread.currentThread().getName() + "循环遍历："
                        + it.next());
            }
        }

    }

}

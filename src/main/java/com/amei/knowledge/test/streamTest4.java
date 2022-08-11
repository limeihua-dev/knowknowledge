package com.amei.knowledge.test;

import java.util.ArrayList;
import java.util.Iterator;

public class streamTest4 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            arrayList.add(Integer.valueOf(i));
        }

        Iterator<Integer> iterator = arrayList.iterator();
        // 复现方法一
//        while (iterator.hasNext()) {
//            Integer integer = iterator.next();
//            if (integer.intValue() == 5) {
//                arrayList.remove(integer);
//            }
//        }

        // 复现方法二
        iterator = arrayList.iterator();
        for (Integer value : arrayList) {
            Integer integer = iterator.next();
            if (integer.intValue() == 5) {
                arrayList.remove(integer);
            }
        }
    }
}

package com.amei.knowledge.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class test3 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            arrayList.add(Integer.valueOf(i));
        }
        ListIterator<Integer> iterator = arrayList.listIterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            if (integer.intValue() == 5) {
                iterator.set(Integer.valueOf(6));
                iterator.remove();
                iterator.add(integer);
            }
        }
    }

}

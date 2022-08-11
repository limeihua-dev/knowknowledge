package com.amei.knowledge.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class streamTest3 {
    public static void main(String[] args) {
        Collection collection = new ArrayList();
        Iterator it = collection.iterator();
        collection.add("a");
        collection.add("b");
        while (it.hasNext()) {
            // Object o = it.next();
            String s = it.next().toString();
            System.out.println(s);
            it.remove();
        }
    }
}

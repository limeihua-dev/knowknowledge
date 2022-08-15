package com.amei.knowledge.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class streamTest2 {
    public static void main(String[] args) {
        List<String> Alist = new ArrayList<>();
        List<String> Blist = new ArrayList<>();
        Alist.add("A");
        Alist.add("B");
        Alist.add("C");
        System.out.println(Alist);
        System.out.println("===");
        int i = 1;
        for (String s : Alist) {
            System.out.println(i + " " + s);
            Blist.add(s);
            System.out.println();
            i++;
            if (s.equals("B")) {
//                Alist.remove(s);
                Alist.add("S");
            }

        }


//        for (int j = 0; j < Alist.size(); j++) {
//            String s = Alist.get(j);
//            if (s.equals("B")) {
//                Alist.remove(s);
//                Alist.add("C");
//            }
//        }

        System.out.println(Alist);
        System.out.println();
        System.out.println(Blist);

    }
}

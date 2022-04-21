package com.amei.knowledge.javaDemo.streamAnd函数编程;

import com.amei.knowledge.entity.Dog;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class max {
    public static void main(String[] args) {
        List<Dog> lists = new ArrayList<Dog>();
        lists.add(new Dog(1L, "p1"));
        lists.add(new Dog(2L, "p2"));
        lists.add(new Dog(3L, "p3"));
        lists.add(new Dog(4L, "p4"));
        Dog a = lists.stream().max(Comparator.comparing(t -> t.getAge())).get();
        System.out.println(a.getAge());



        Dog dog = lists.stream().min(new Comparator<Dog>() {
            @Override
            public int compare(Dog o1, Dog o2) {
                if (o1.getAge() > o2.getAge()) return -1;
//                if (o1.getAge() < o2.getAge()) return 1;
                return 0;
            }
        }).get();
        System.out.println(dog.getAge());
    }
}

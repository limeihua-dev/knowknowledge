package com.amei.knowledge.javaDemo.streamAnd函数编程;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class aboutFilter {

    public static void main(String[] args) {

        List languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

        System.out.println("Languages which starts with J :");
        filter(languages, (str)->str.toString().startsWith("J"));

        System.out.println("Languages which ends with a ");
        filter(languages, (str)->str.toString().endsWith("a"));

        System.out.println("Print all languages :");
        filter(languages, (str)->true);

        System.out.println("Print no language : ");
        filter(languages, (str)->false);

        System.out.println("Print language whose length greater than 4:");
        filter(languages, (str)->str.toString().length() > 4);
    }

    public static void filter(List names, Predicate condition) {
        names.stream().filter((name) -> (condition.test(name))).forEach((name) -> {
            System.out.println(name + " ");
        });
        System.out.println("==================");
    }
}

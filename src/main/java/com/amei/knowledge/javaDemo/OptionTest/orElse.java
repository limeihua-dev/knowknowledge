package com.amei.knowledge.javaDemo.OptionTest;

import java.util.Optional;
/*
* 如果有值则将其返回，否则返回指定的其它值。
* */
public class orElse {
    public static void main(String[] args) {

//        map方法执行传入的lambda表达式参数对Optional实例的值进行修改。
//        为lambda表达式的返回值创建新的Optional实例作为map方法的返回值。
        Optional<String> name = Optional.of("ewew");
        Optional<String> name1 = Optional.of("ewew");
//        Optional<String> name1 = Optional.of(null);
        Optional<String> upperName = name.map((value) -> value.toUpperCase());
        Optional<String> upperName1 = name.filter((value) -> value.length()>5);
        System.out.println(upperName.orElse("No value found"));
        System.out.println(upperName1.orElse("No value found11111"));
    }
}

package com.amei.knowledge.算法题;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class 获取List的泛型类型 {
    public static void main(String[] args) throws NoSuchFieldException {
        Class clazz = A.class;
        Field field = clazz.getField("list");
        ParameterizedType type = (ParameterizedType) field.getGenericType();
        Stream.of(type.getActualTypeArguments()).forEach(System.out::println);

        field = clazz.getField("list1");
        type = (ParameterizedType) field.getGenericType();
        Stream.of(type.getActualTypeArguments()).forEach(System.out::println);
    }

    class A {
        public List<? extends String> list = new ArrayList<>();

        public List<Integer> list1 = new ArrayList<>();
    }
}

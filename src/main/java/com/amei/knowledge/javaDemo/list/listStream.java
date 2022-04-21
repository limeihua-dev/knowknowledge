package com.amei.knowledge.javaDemo.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class listStream {
    public static void main(String[] args) {
//        ArrayList<String> list = new ArrayList<>();
//        HashMap<Object, Object> map = new HashMap<>();
//
//        //list集合去重
//        list.stream().distinct().collect(Collectors.toList());
//
//        //map 转list
//        map.keySet().stream().collect(Collectors.toList());

        //remain
        String[] aList = {"001","002","003","004"};
        String[] bList = {"002","003","004"};
        List<String> alist = Arrays.asList(aList);
        List<String> blist = Arrays.asList(bList);

        
        System.out.println(blist.contains("002"));//true
    }
}

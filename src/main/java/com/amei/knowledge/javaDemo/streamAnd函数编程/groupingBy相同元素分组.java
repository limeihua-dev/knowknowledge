package com.amei.knowledge.javaDemo.streamAnd函数编程;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class groupingBy相同元素分组 {
    public static void main(String[] args) {
        List<String> phones=new ArrayList<String>();
        phones.add("a");
        phones.add("b");
        phones.add("a");
        phones.add("a");
        phones.add("c");
        phones.add("b");
        Map<String, List<String>> phoneClassify = phones.stream().collect(Collectors.groupingBy(item -> item));
        System.out.println(phoneClassify);
//        返回结果:
//        {a=[a, a, a], b=[b, b], c=[c]}
    }
}

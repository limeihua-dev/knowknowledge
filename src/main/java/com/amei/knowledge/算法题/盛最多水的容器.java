package com.amei.knowledge.算法题;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 盛最多水的容器 {
    public static int maxArea(Integer[] height) {
        List<Integer> integers = Arrays.asList(height);
        System.out.println(integers.size());
        if (height.length == 2) {
            Collections.min(Arrays.asList(height));
        }
        return 0;
    }

    public static void main(String[] args) {
//        Integer[] integers =  {1,8,6,2,5,4,8,3,7};
//        maxArea(integers);
    }
}

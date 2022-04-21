package com.amei.knowledge.javaDemo.Arrays;

import java.util.Arrays;
/*
* 如果数组中存在该元素，则会返回该元素在数组中的下标
* 如果数组中不存在该元素，则会返回 -(插入点 + 1)         插入点指的是：如果该数组中存在该元素，那个元素在该数组中的下标
* */
public class BinarySearch {
    public static void main(String[] args) {

        int[] scores = {1, 20, 30, 40, 50};
        //调用java提供的binarySearch方法
        //下表从0开始
        int a = Arrays.binarySearch(scores, 60);
        System.out.println(a);
    }

    //原理：
    //自定义二分查找函数
    public static int myBinarySearch(int [] array, int key) {
        int low = 0; //左下标
        int high = array.length - 1;   //右下标
        int mid = (low + high) / 2;   //中间值

        while(low <= high) {
            if(key < array[mid])     //如果需要比较的值 < 数组中该下标下的值
                high = mid - 1;      //往左边查
            else if(key > array[mid])
                low = mid + 1;       //往右边查
            else
                return mid;
        }
        return -(1 + low);
    }

}




package com.amei.knowledge.javaDemo.arithmeticSort;

/**
 * https://www.runoob.com/w3cnote/insertion-sort.html
 * 分区：有序区和无序区
 */
public class 插序排序 {
    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 3, 5, 7, 2, 9, 8, 6};
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[i] < arr[j]) {
                //找到最小的值的下标
                j--;
            }
            if (i != j) {
                arr[j] = arr[i];
                
            }
            for (int k = 0; k < arr.length; k++) {
                System.out.print(arr[k] + " ");
            }
            System.out.println("   ");
        }
    }
}

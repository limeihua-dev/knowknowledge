package com.amei.knowledge.javaDemo.arithmeticSort;

public class 冒泡排序 {
    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 3, 5, 7, 2, 9, 8, 6};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

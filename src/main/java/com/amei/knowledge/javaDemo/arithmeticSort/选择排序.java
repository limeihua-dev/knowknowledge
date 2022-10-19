package com.amei.knowledge.javaDemo.arithmeticSort;

public class 选择排序 {
    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 3, 5, 7, 2, 9, 8, 6};

        for (int i = 0; i < arr.length - 1; i++) {
            int temp = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[temp] > arr[j]) {
                    temp = j;
                }
            }
            if (temp != i) {
                int tmp = arr[i];
                arr[i] = arr[temp];
                arr[temp] = tmp;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

package com.amei.knowledge.test;

public class SystemCopyTest {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] arr2 = {5, 6, 7, 8, 9};
        System.arraycopy(arr, 1, arr2, 0, 3);
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i]+" ");
        }

    }
}

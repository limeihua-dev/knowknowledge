package com.amei.knowledge.算法题;

import java.util.HashMap;

public class 俩数之和为9的下标 {

    public static int[] twoNumAdd(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int partnerNumber = target - nums[i];
            if (map.containsKey(partnerNumber)) {
                return new int[]{map.get(partnerNumber),i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] x = twoNumAdd(nums, target);
        System.out.println(x[0]);
        System.out.println(x[1]);
    }
}

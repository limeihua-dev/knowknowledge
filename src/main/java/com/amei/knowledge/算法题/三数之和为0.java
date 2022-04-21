package com.amei.knowledge.算法题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class 三数之和为0 {
    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length < 2)
            return lists;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[0] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int target = -nums[i];
            int L = i + 1;
            int R = nums.length - 1;
            while (L < R) {
                if (nums[L] + nums[R] == target) {
                    lists.add(Arrays.asList(nums[L], nums[R], nums[i]));
                    L++;
                    R--;
                    while (L < R && nums[L] == nums[L - 1]) L++;
                    while (L < R && nums[R] == nums[R + 1]) R--;
                } else if (nums[L] + nums[R] < target) {
                    L++;
                }else{
                    R--;
                }

            }
        }
        return lists;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }
}

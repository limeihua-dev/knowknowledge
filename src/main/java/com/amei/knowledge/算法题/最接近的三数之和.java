package com.amei.knowledge.算法题;

import java.util.Arrays;

public class 最接近的三数之和 {
    public static int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3)
            return 0;
        int length = nums.length - 1;
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i <= length; i++) {
            int L = i + 1;
            int R = length;
            while (L < R) {
                int sum = nums[L] + nums[R] + nums[i];
                if (Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum;
                }
                if (sum > target)
                    R--;
                else if (sum > target)
                    L++;
                else
                    return ans;
            }
        }
        return ans;
    }
}

package com.amei.knowledge.算法题;

/**
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 */

/**
 * 解法：
 * #左边界具有二段性:索引小于左边界的其值必定小于target,可以利此进行主动排除
 * #右边界具有二段性:索引大于右边界的其值必定大于target,可以利此进行主动排除
 */
public class 在排序数组中查找元素的第一个和最后一个位置 {
    public static int[] searchRange(int[] nums, int target) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        if (length == 0) {
            return new int[]{-1, 1};
        } else {
            //查找元素的左边界
            while (left < right) {
                int medim = left + (right - left) / 2;
                if (nums[medim] < target) {
                    //右边
                    left = medim + 1;
                } else {
                    //左边
                    right = medim;
                }
            }
            int L = left;//左边界
            int l = 0;
            int r = length - 1;
            while (l < r) {
                // 右边界主动向左收缩->偏右
                int medim = l + (r - l + 1) / 2;
                if (nums[medim] > target) {
                    r = medim - 1;
                } else {
                    l = medim;
                }
            }
            //查找元素的右边界
            int R = r;//右边界
            return nums[left] != target ? new int[]{-1, -1} :new int[]{L, R};
        }
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 6;
        int[] ints = searchRange(nums, target);
        for (int item : ints) {
            System.out.println(item);
        }
    }
}

package com.lvhaifeng.leetcode;

import java.util.Arrays;

/**
 * @Description 31. 下一个排列
 * @Author haifeng.lv
 * @Date 2021/9/13 10:22
 */
public class NextPermutation {
    public static void main(String[] args) {
//        int[] nums = {1, 2, 3};
//        int[] nums = {3, 2, 1};
//        int[] nums = {2, 3, 1}; // 3, 1, 2
//        int[] nums = {1, 6, 5};
        int[] nums = {9, 1, 8, 9, 7, 6, 5}; // 1, 9, 5, 6, 7, 8
//        int[] nums = {1, 2};
//        int[] nums = {5, 1, 1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 我是废物
     * @param nums
     */
    public static void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }

        int max = nums[nums.length - 1];
        int i = nums.length - 2;

        while (i >= 0) {
            if (max <= nums[i]) {
                max = nums[i];
                i--;
            } else {
                break;
            }
        }

        if (i < 0) {
            // 如果走到了首位, 直接调换
            exchange(0, nums.length - 1, nums);
        } else {
            int j = nums.length - 1;
            // 如果没有走到首位, 则找到比 num[i] 小一点的数
            while (j >= 0) {
                if (nums[i] < nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    break;
                }
                j--;
            }

            exchange(i + 1, nums.length - 1, nums);
        }
    }

    public static void exchange(int left, int right, int[] nums) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}

package com.lvhaifeng.leetcode;

/**
 * @Description
 * @Author haifeng.lv
 * @Date 2021/9/6 9:20
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int removeElement = removeElement(nums, 2);
        for (int i = 0; i < removeElement; i++) {
            System.out.printf(nums[i] + "\t");
        }
        System.out.println();
    }

    public static int removeElement(int[] nums, int val) {
        if (null == nums) {
            return 0;
        }

        int left = 0, right = nums.length;
        while (left < right) {
            if (val == nums[left]) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }
}

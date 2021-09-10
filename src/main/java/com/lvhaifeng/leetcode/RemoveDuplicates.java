package com.lvhaifeng.leetcode;

/**
 * @Description 删除有序数组中的重复项
 * @Author haifeng.lv
 * @Date 2021/9/6 9:17
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        int removeDuplicates = removeDuplicates(nums);
        for (int i = 0; i < removeDuplicates; i++) {
            System.out.printf(nums[i] + "\t");
        }
        System.out.println();
    }

    public static int removeDuplicates(int[] nums) {
        if (null == nums) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }

        int length = nums.length;
        int k = 0, i = 1;
        while (i < length) {
            while (i < length && nums[k] == nums[i]) {
                i++;
            }

            if (i == length) {
                break;
            }

            k++;
            nums[k] = nums[i];
            i++;
        }
        return ++k;
    }
}

package com.lvhaifeng.leetcode;

import java.util.Arrays;

/**
 * @Description
 * @Author haifeng.lv
 * @Date 2021/8/28 19:17
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums = {1, 1, -1, -1, 3};
        int closest = threeSumClosest(nums, -1);
        System.out.println(closest);
    }

    public static int threeSumClosest(int[] nums, int target) {
        if (null == nums || nums.length < 3) {
            return 0;
        }

        Arrays.sort(nums);
        int n = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (j == i + 1 || nums[j] != nums[j - 1]) {
                        for (int k = j + 1; k < nums.length; k++) {
                            if (k == j + 1 || nums[k] != nums[k - 1]) {
                                if (Math.abs(target - n) > Math.abs(target - (nums[i] + nums[j] + nums[k]))) {
                                    n = nums[i] + nums[j] + nums[k];
                                }
                            }
                        }
                    }
                }
            }
        }

        return n;
    }
}

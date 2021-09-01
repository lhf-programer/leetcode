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
        int n = 100000000;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int j = i + 1;
                int k = nums.length - 1;

                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == target) {
                        return target;
                    }

                    if (Math.abs(target - n) > Math.abs(target - sum)) {
                        n = sum;
                    }

                    if (sum > target) {
                        int k0 = k;
                        while (k0 > j && nums[k] == nums[k0]) {
                            k0--;
                        }
                        k = k0;
                    } else {
                        int j0 = j;
                        while (j0 < k && nums[j] == nums[j0]) {
                            j0++;
                        }
                        j = j0;
                    }

                }
            }
        }

        return n;
    }
}

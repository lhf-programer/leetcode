package com.lvhaifeng.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Author haifeng.lv
 * @Date 2021/9/1 16:47
 */
public class FourSum {
    public static void main(String[] args) {
//        int[] nums = {1, 0, -1, 0, -2, 2};
//        int[] nums = {2, 2, 2, 2, 2};
        int[] nums = {-2, -1, -1, 1, 1, 2, 2};
        List<List<Integer>> lists = fourSum(nums, 0);
        System.out.println(lists);
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // 排序
        Arrays.sort(nums);

        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                for (int j = i + 1; j < length; j++) {
                    if (j == i + 1 || nums[j] != nums[j - 1]) {
                        int n = length - 1;
                        for (int k = j + 1; k < length; k++) {
                            if (k == j + 1 || nums[k] != nums[k - 1]) {
                                while (n > k && nums[i] + nums[j] + nums[k] + nums[n] > target) {
                                    n--;
                                }

                                if (n == k) {
                                    break;
                                }

                                if (nums[i] + nums[j] + nums[k] + nums[n] == target) {
                                    result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[n]));
                                }
                            }
                        }
                    }
                }
            }
        }

        return result;
    }
}

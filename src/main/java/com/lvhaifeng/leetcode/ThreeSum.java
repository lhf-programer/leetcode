package com.lvhaifeng.leetcode;

import com.lvhaifeng.leetcode.utils.PrintArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 三数之和
 * @Author haifeng.lv
 * @Date 2021/8/27 16:52
 */
public class ThreeSum {
    public static void main(String[] args) {
//        int[] nums = {-1, 0, 1, 2, -1, -4};
//        int[] nums = {-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0};
//        int[] nums = {0, 0, 0};
//        int[] nums = {0, 0, 0, 0};
        int[] nums = {3, 0, -2, -1, 1, 2};
//        int[] nums = {0, 7, -4, -7, 0, 14, -6, -4, -12, 11, 4, 9, 7, 4, -10, 8, 10, 5, 4, 14, 6, 0, -9, 5, 6, 6, -11, 1, -8, -1, 2, -1, 13, 5, -1, -2, 4, 9, 9, -1, -3, -1, -7, 11, 10, -2, -4, 5, 10, -15, -4, -6, -8, 2, 14, 13, -7, 11, -9, -8, -13, 0, -1, -15, -10, 13, -2, 1, -1, -15, 7, 3, -9, 7, -1, -14, -10, 2, 6, 8, -6, -12, -13, 1, -3, 8, -9, -2, 4, -2, -3, 6, 5, 11, 6, 11, 10, 12, -11, -14};
        List<List<Integer>> lists = threeSum2(nums);

        for (List<Integer> list : lists) {
            System.out.println();
            for (Integer integer : list) {
                System.out.printf(integer + "\t");
            }
        }
        System.out.println();
    }

    /**
     * 自己写得垃圾
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        int length = nums.length;
        if (length < 3) {
            return lists;
        }

        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                num++;
            }
        }
        if (num > 2) {
            lists.add(Arrays.asList(0, 0, 0));
        }

        for (int i = 0; i < length; i++) {
            for (int j = 2; j < length; j++) {
                for (int k = 0; k < length; k++) {
                    int n = k + j - 1;

                    if (n >= length) {
                        break;
                    }


                    if (nums[i] == nums[n] && nums[n] == nums[k]) {
                        continue;
                    }
                    if (i == n || n == k || i == k) {
                        continue;
                    }
                    if (nums[i] == 0 && nums[k] == 0 && nums[n] == 0) {
                        System.out.println(nums[i] + " " + nums[k] + " " + nums[n]);
                    }

                    if (isMatch(nums[i], nums[k], nums[n], lists) && (nums[i] + nums[k] + nums[n]) == 0) {
                        lists.add(Arrays.asList(nums[i], nums[k], nums[n]));
                    }
                }
            }
        }

        return lists;
    }

    public static boolean isMatch(int i, int j, int k, List<List<Integer>> lists) {
        for (List<Integer> list : lists) {
            if (list.contains(i) && list.contains(j) && list.contains(k)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 优化
     * 排序加双向指针
     *
     * 预先排好序
     * 我们先预防一种情况的发生（第二次循环在第一次循环的基础上循环 j = i + 1, j < nums.length）
     * a + b + c = 0 的话, 我们不需要枚举 a + c + b, c + b + a 的情况
     *
     * 固定循环一次
     * 第二次循环在第一次循环的基础上循环, 并且我们需要避免相同的数字 nums[j] != num[j - 1]
     *
     * 由 a + b + c = 0 可知, 如果我们 a, b 固定的话, 最后是否等于 0 取决于 c
     * 定义变量 n从末尾循环（其实就是第三次循环）, 也就是 c必须大于 j
     * 也就是说如果 b + c > -a 的话, 我们就一直将 c递减直至满足 b + c = -a
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();

        System.out.println("选择排序");
        int temp = 0;
        int k = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            k = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[k]) {
                    k = j;
                }
            }

            if (k != i) {
                temp = nums[k];
                nums[k] = nums[i];
                nums[i] = temp;
            }
        }

        System.out.println(Arrays.toString(nums));

        for (int i = 0; i < nums.length; i++) {
            int n = nums.length - 1;
            int target = -nums[i];

            if (i == 0 || nums[i] != nums[i - 1]) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (j == i + 1 || nums[j] != nums[j - 1]) {
                        while (n > j && nums[j] + nums[n] > target) {
                            n--;
                        }
                        if (n == j) {
                            break;
                        }

                        if (nums[j] + nums[n] == target) {
                            lists.add(Arrays.asList(nums[i], nums[j], nums[n]));
                        }
                    }
                }
            }
        }

        return lists;
    }
}

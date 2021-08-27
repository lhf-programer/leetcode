package com.lvhaifeng.leetcode;

import com.lvhaifeng.leetcode.utils.PrintArray;

/**
 * @Description 盛最多水的容器
 * @Author haifeng.lv
 * @Date 2021/8/26 9:12
 */
public class MaxArea {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
//        int[] height = {1, 2};
//        int[] height = {2, 3, 10, 5, 7, 8, 9};
//        int[] height = {1, 1};
        int maxArea = maxArea4(height);
        System.out.println("最多容量: " + maxArea);
    }

    /**
     * 自己写的垃圾
     * <p>
     * 动态规划
     * 构建 int[length][length]: length 为数组长度
     * <p>
     * 状态转移方程
     * f[i][j] = max((j - i) * min(s[i], s[j]), max(f[i + 1][j], f[i][j - 1]))
     * <p>
     * 超出内存限制
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int length = height.length;
        int[][] maxArea = new int[length][length];
        for (int k = 2; k <= length; k++) {
            for (int i = 0; i < length; i++) {
                int j = k + i - 1;

                if (j >= length) {
                    break;
                }

                int minNum = Math.min(height[i], height[j]);
                maxArea[i][j] = Math.max((j - i) * minNum, Math.max(maxArea[i + 1][j], maxArea[i][j - 1]));
            }
        }

        PrintArray.printArray(maxArea);
        System.out.println();

        return maxArea[0][length - 1];
    }

    /**
     * 自己写的垃圾
     * 暴力破解
     * <p>
     * 超出时间限制
     *
     * @param height
     * @return
     */
    public static int maxArea2(int[] height) {
        int max = 0;

        for (int i = 0; i < height.length; i++) {
            for (int j = 0; j < height.length; j++) {
                int minNum = Math.min(height[i], height[j]);
                max = Math.max(max, (j - i) * minNum);
            }
        }

        return max;
    }

    /**
     * 再次优化!
     *
     * 超出时间限制
     * @param height
     * @return
     */
    public static int maxArea3(int[] height) {
        int length = height.length;
        int max = 0;

        for (int k = 2; k <= length; k++) {
            for (int i = 0; i < length; i++) {
                int j = k + i - 1;

                if (j >= length) {
                    break;
                }

                int minNum = Math.min(height[i], height[j]);
                max = Math.max(max, Math.max((j - i) * minNum, Math.max(Math.min(height[i + 1], height[j]) * (j - i - 1), Math.min(height[i], height[j - 1]) * (j - i - 1))));
            }
        }

        return max;
    }

    /**
     * 只好抄答案了!
     * @param height
     * @return
     */
    public static int maxArea4(int[] height) {
        int max = 0;
        int i = 0;
        int j = height.length - 1;

        while (i < j) {
            int minNum = Math.min(height[i], height[j]);
            max = Math.max(max, (j - i) * minNum);

            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}

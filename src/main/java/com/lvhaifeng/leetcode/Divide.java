package com.lvhaifeng.leetcode;

/**
 * @Description 两数相除
 * @Author haifeng.lv
 * @Date 2021/9/10 11:15
 */
public class Divide {
    public static void main(String[] args) {
        int dividend = -2147483648, divisor = 1;
        int divide = divide2(dividend, divisor);
        System.out.println(divide);
    }

    /**
     * 自己写的垃圾
     * 超时
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public static int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        int index = 0, n = divisor;
        /*
         * 分3种情况
         * 1 全是整数（结果必为正数）
         * 2 全是负数（结果必为正数）
         * 3 一负一正（结果必为负数）
         */
        if (dividend > 0 && divisor > 0) {
            // 全是整数
            while (dividend >= n) {
                index++;
                n += divisor;
            }

            return index;
        } else if (dividend < 0 && divisor < 0) {
            // 全是负数
            while (dividend <= n) {
                index++;
                n += divisor;
            }

            return index;
        } else {
            // 一负一正
            while (Math.abs(dividend) >= Math.abs(n)) {
                index--;
                n += divisor;
            }

            return index;
        }
    }

    public static int divide2(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // ^ 异或 操作, 如果小于 0则为负数, 反之为正数
        boolean flag = (dividend ^ divisor) < 0;
        int result = 0;
        long n = Math.abs((long) dividend), m = Math.abs((long) divisor);

        for (int i = 31; i >= 0; i--) {
            if ((n >> i) >= m) {
                result += 1 << i;
                n -= m << i;
            }
        }

        return flag ? -result : result;
    }
}

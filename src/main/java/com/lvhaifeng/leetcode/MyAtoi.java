package com.lvhaifeng.leetcode;

/**
 * @Description 字符串转换整数 (atoi)
 * @Author haifeng.lv
 * @Date 2021/8/24 16:14
 */
public class MyAtoi {
    public static void main(String[] args) {
//        String s = "42";
//        String s = "-42";
//        String s = "4193 with words";
//        String s = "words and 987";
//        String s = "-91283472332";
//        String s = "+-12";
//        String s = "2147483648";
//        String s = "-2147483649";
//        String s = "-91283472332";
//        String s = "  +  413";
        String s = " -1010023630o4";
        int i = myAtoi(s);
        System.out.println("字符串转换整数: " + i);
    }

    public static int myAtoi(String s) {
        if (null == s || "".equals(s)) {
            return 0;
        }

        int res = 0;
        int operation = 0;
        boolean flag = false;

        for (int i = 0; i < s.toCharArray().length; i++) {
            char c = s.charAt(i);

            // ' '
            if (c == 32) {
                if (flag || operation != 0) {
                    break;
                }
                continue;
            }

            // '-'
            if (c == 45) {
                if (operation != 0 || flag) {
                    break;
                }
                operation = 1;
                continue;
            }

            // '+'
            if (c == 43) {
                if (operation != 0 || flag) {
                    break;
                }
                operation = 2;
                continue;
            }

            if (c < 48 || c > 57) {
                break;
            }

            if (res < Integer.MIN_VALUE / 10) {
                return Integer.MIN_VALUE;
            } else if (res == Integer.MIN_VALUE / 10 && Integer.parseInt(c + "") > 8) {
                return Integer.MIN_VALUE;
            }

            if (res > Integer.MAX_VALUE / 10) {
                return Integer.MAX_VALUE;
            } else if (res == Integer.MAX_VALUE / 10 && Integer.parseInt(c + "") > 7) {
                return Integer.MAX_VALUE;
            }

            res = res * 10 + (operation == 1 ? -Integer.parseInt(c + "") : Integer.parseInt(c + ""));
            // 存在先导数字
            flag = true;
        }

        return res;
    }
}

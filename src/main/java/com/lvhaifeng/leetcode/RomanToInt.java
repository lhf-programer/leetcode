package com.lvhaifeng.leetcode;

/**
 * @Description 罗马数字转整数
 * @Author haifeng.lv
 * @Date 2021/8/26 16:05
 */
public class RomanToInt {
    public static void main(String[] args) {
//        String s = "IV";
//        String s = "IX";
//        String s = "LVIII";
        String s = "MCMXCIV";
        int i = romanToInt(s);
        System.out.println(i);
    }

    public static int romanToInt(String s) {
        int res = 0;

        char[] sChars = s.toCharArray();
        int n = 0;

        for (int i = sChars.length - 1; i >= 0; i--) {
            int num = getInt(sChars[i]);

            if (n <= num) {
                // +
                res += num;
                n = num;
            } else {
                // -
                res -= num;
            }
        }

        return res;
    }

    public static int getInt(char s) {
        switch (s) {
            case 'M':
                return 1000;
            case 'D':
                return 500;
            case 'C':
                return 100;
            case 'L':
                return 50;
            case 'X':
                return 10;
            case 'V':
                return 5;
            case 'I':
                return 1;
            default:
                return 0;
        }
    }
}

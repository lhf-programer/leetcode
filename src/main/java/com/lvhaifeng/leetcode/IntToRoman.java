package com.lvhaifeng.leetcode;

/**
 * @Description 整数转罗马数字
 * @Author haifeng.lv
 * @Date 2021/8/26 14:32
 */
public class IntToRoman {
    public static void main(String[] args) {
//        int num = 1994;
//        int num = 58;
//        int num = 9;
//        int num = 4;
        int num = 3;
        String intToRoman = intToRoman(num);
        System.out.println(intToRoman);
    }

    public static String intToRoman(int num) {
        String temp = "";
        int n = 1000;

        while (n != 0) {
            if (num / n != 0) {
                if (num / n == 9) {
                    temp += getChar(n) + getChar(n * 10);
                    num = num % n;
                    n /= 10;
                    continue;
                }

                if (num / n == 4) {
                    temp += getChar(n) + getChar(n * 5);
                    num = num % n;
                    n /= 10;
                    continue;
                }

                if (num >= 5 * n) {
                    temp += getChar(n * 5);
                    num = num % (n * 5);
                }

                for (int j = 0; j < num / n; j++) {
                    temp += getChar(n);
                }
                num = num % n;
                n /= 10;
            } else {
                n /= 10;
            }
        }

        return temp;
    }

    public static String getChar(int num) {
        switch (num) {
            case 1000:
                return "M";
            case 500:
                return "D";
            case 100:
                return "C";
            case 50:
                return "L";
            case 10:
                return "X";
            case 5:
                return "V";
            case 1:
                return "I";
            default:
                return "";
        }
    }
}

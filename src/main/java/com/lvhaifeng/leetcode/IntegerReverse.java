package com.lvhaifeng.leetcode;

/**
 * @Description 整数反转
 * @Author haifeng.lv
 * @Date 2021/8/24 14:08
 */
public class IntegerReverse {
    public static void main(String[] args) {
//        int x = 123;
//        int x = -123;
        int x = 120;
//        int x = -1534236469;
//        int x = -2147483412;
//        int x = 1563847412;
        int reverse = reverse2(x);
        System.out.println(reverse);
    }

    /**
     * 自己写的垃圾
     * @param x
     * @return
     */
    public static int reverse(int x) {
        if (x == 0) {
            return 0;
        }

        String max = Integer.MAX_VALUE + "";
        String min = new StringBuilder(Integer.MIN_VALUE + "").substring(1);

        StringBuilder stringBuilder = new StringBuilder(x + "");
        String temp;
        boolean flag;
        if (stringBuilder.indexOf("-") != -1) {
            temp = new StringBuilder(stringBuilder.substring(1)).reverse().toString();
            flag = true;
        } else {
            temp = stringBuilder.reverse().toString();
            flag = false;
        }

        if (temp.length() == 10) {
            if (flag) {
                for (int i = 0; i < min.toCharArray().length; i++) {
                    if (temp.charAt(i) > min.charAt(i)) {
                        return 0;
                    } else if (temp.charAt(i) < min.charAt(i)) {
                        break;
                    }
                }

                return Integer.parseInt("-" + temp);
            } else {
                for (int i = 0; i < max.toCharArray().length; i++) {
                    if (temp.charAt(i) > max.charAt(i)) {
                        return 0;
                    } else if (temp.charAt(i) < max.charAt(i)) {
                        break;
                    }
                }

                return Integer.parseInt(temp);
            }
        } else {
            if (flag) {
                stringBuilder.substring(1, stringBuilder.length());
                return Integer.parseInt("-" + temp);
            } else {
                return Integer.parseInt(temp);
            }
        }
    }

    /**
     * 最优解
     * @param x
     * @return
     */
    public static int reverse2(int x) {
        int res = 0;

        while(x != 0) {
            if (res < Integer.MIN_VALUE / 10 || res > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digital = x % 10;
            x /= 10;
            res = res * 10 + digital;
        }

        return res;
    }
}

package com.lvhaifeng.leetcode;

import com.lvhaifeng.leetcode.utils.PrintArray;

/**
 * @Description 正则表达式匹配
 * @Author haifeng.lv
 * @Date 2021/8/24 20:31
 */
public class RegularExpression {
    public static void main(String[] args) {
        String s = "aaab";
        String p = "aaa";
//        String s = "aa";
//        String p = "a*";

        boolean match = isMatch(s, p);
        System.out.println(match);
    }

    /**
     * 自己写的垃圾
     *
     * f[][] 动态规划数组
     * s[] 原字符串 p[] 匹配字符串
     * 状态转移方程:
     * 如果p[j] 不为 '*': f[i][j] = f[i - 1][j - 1] 则一定成立
     * 如果p[j] 为 '*': 就要考虑两种情况
     *      1. 如果 p[j - 1] != s[i]: f[i][j] = f[i][j - 2] 则一定成立
     *      2. 如果 p[j - 1] == s[i]: f[i][j] = f[i - 1][j] 或则 f[i][j] = f[i][j - 2] 则一定成立
     *          其中 f[i][j] = f[i - 1][j] 指 s 字符串已经匹配完了还没有出现字符不一样的情况
     *               f[i][j] = f[i][j - 2] 指 s 字符串还没有匹配完就出现了不一样的字符串
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }

            PrintArray.printArray(f);
        }

        System.out.println();
        return f[m][n];
    }

    public static boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    /*public static boolean isMatch(String s, String p) {
        char[] sChars = s.toCharArray();
        String[] pSubstring = p.split(SYMBOL2);

        int index = 0;
        Character lastChar = null;
        for (int i = 0; i < pSubstring.length; i++) {
            String substring = pSubstring[i];
            char[] pChars = substring.toCharArray();
            if (null != lastChar && lastChar == SYMBOL1) {
                return true;
            }

            int j = 0;
            if (substring.startsWith(lastChar + "")) {
                while (j < pChars.length) {
                    if (index == sChars.length) {
                        return false;
                    }

                    if (pChars[j] != SYMBOL1 && sChars[index] != pChars[j]) {
                        return false;
                    } else {
                        index++;
                        j++;
                    }
                }
            }

            while (j < pChars.length) {
                if (index == sChars.length) {
                    return false;
                }

                if (pChars[j] != SYMBOL1 && sChars[index] != pChars[j]) {
                    return false;
                } else {
                    index++;
                    j++;
                }
            }

            lastChar = pChars[substring.length() - 1];
        }

        if (index == sChars.length - 1) {
            if (null == lastChar) {
                return false;
            }

            return sChars[index] == lastChar;
        } else if (index < sChars.length - 1) {
            return false;
        } else {
            return true;
        }
    }*/

}

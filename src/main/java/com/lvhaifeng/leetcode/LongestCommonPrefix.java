package com.lvhaifeng.leetcode;

/**
 * @Description 最长公共前缀
 * @Author haifeng.lv
 * @Date 2021/8/27 9:15
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
//        String[] strs = {"flower", "flow", "flight"};
//        String[] strs = {"dog", "racecar", "car"};
//        String[] strs = {"cir", "car"};
//        String[] strs = {"aaa", "aa", "aaa"};
        String[] strs = {"a", "b"};
        String prefix = longestCommonPrefix2(strs);
        System.out.println("公共前缀: " + prefix);
    }

    /**
     * 自己写得垃圾
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        String temp = matchPrefix(strs[0], strs[strs.length - 1]);

        int i = 1;
        int j = strs.length - 2;

        while (i <= j) {
            String str1 = matchPrefix(temp, strs[i]);
            String str2 = matchPrefix(temp, strs[j]);

            temp = str1.length() > str2.length() ? str2 : str1;
            if ("".equals(temp)) {
                return temp;
            }

            i++;
            j--;
        }

        return temp;
    }

    public static String matchPrefix(String s1, String s2) {
        String temp = "";
        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();

        int min = Math.min(s1Chars.length, s2Chars.length);
        for (int i = 0; i < min; i++) {
            if (s1Chars[i] == s2Chars[i]) {
                temp += s1Chars[i];
            } else {
                break;
            }
        }

        return temp;
    }

    /**
     * 优解（二分查找）
     * @param strs
     * @return
     */
    public static String longestCommonPrefix2(String[] strs) {
        if (null == strs || strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            min = Math.min(min, strs[i].length());
        }

        int low = 0, height = min;
        while (low < height) {
            int mid = (height - low + 1) / 2 + low;
            if (matchPrefix2(strs, mid)) {
                low = mid;
            } else {
                height = mid - 1;
            }
        }

        return strs[0].substring(0, low);
    }

    public static boolean matchPrefix2(String[] strs, int length) {
        String str0 = strs[0].substring(0, length);

        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            for (int j = 0; j < length; j++) {
                if (str0.charAt(j) != str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}

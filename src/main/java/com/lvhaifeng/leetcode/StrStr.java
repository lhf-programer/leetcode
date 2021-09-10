package com.lvhaifeng.leetcode;

/**
 * @Description
 * @Author haifeng.lv
 * @Date 2021/9/6 15:18
 */
public class StrStr {
    public static void main(String[] args) {
        String haystack = "helllllpo";
        String needle = "po";
//        String haystack = "bbba";
//        String needle = "bba";
//        String haystack = "aaaaa";
//        String needle = "bba";
        int index = strStr2(haystack, needle);
        System.out.println(index);
    }

    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }

        char[] hChars = haystack.toCharArray();
        char[] nChars = needle.toCharArray();
        int j = 0;
        for (int i = 0; i < hChars.length; i++) {
            if (hChars[i] == nChars[j]) {
                j++;
            } else {
                i = i - j;
                j = 0;

                if (hChars.length - i < needle.length()) {
                    break;
                }
            }

            if (j == needle.length()) {
                return i - j + 1;
            }
        }

        return -1;
    }

    /**
     * kmp 算法模式
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr2(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }

        int[] kmpTable = new int[needle.length()];
        int j = 0;
        for (int i = 1; i < needle.length(); i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = kmpTable[j - 1];
            }

            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }

            kmpTable[i] = j;
        }

        int k = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (k > 0 && haystack.charAt(i) != needle.charAt(k)) {
                k = kmpTable[k - 1];
            }

            if (haystack.charAt(i) == needle.charAt(k)) {
                k++;
            }

            if (k == needle.length()) {
                return i - k + 1;
            }
        }

        return -1;
    }
}

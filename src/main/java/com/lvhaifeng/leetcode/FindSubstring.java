package com.lvhaifeng.leetcode;

import java.util.*;

/**
 * @Description 串联所有单词的子串
 * @Author haifeng.lv
 * @Date 2021/9/10 16:16
 */
public class FindSubstring {
    public static void main(String[] args) {
//        String s = "barfoothefoobarman";
//        String[] words = {"foo", "bar", "the"};
//        String s = "wordgoodgoodgoodbestword";
//        String[] words = {"word", "good", "best", "word"};
        String s = "barfoofoobarthefoobarman";
        String[] words = {"bar", "foo", "the"};
        List<Integer> findSubstring = findSubstring3(s, words);
        System.out.println(findSubstring);
    }

    /**
     * 做不出来了！
     * a
     *
     * a b
     * b a
     *
     * a b c
     * a c b
     * b a c
     * b c a
     * c a b
     * c b a
     *
     * a b c d
     * a b d c
     * a c b d
     * a c d b
     * a d b c
     * a d c b
     * b a c d
     * b a d c
     * b c a d
     * b c d a
     * b d a c
     * b d c a
     *
     * 长度规律: s(1:1) s(2:2) s(3:6) s(4:24)
     * 方程: f(x) = f(x - 1) * x (f(0) = 1)
     * @param s
     * @param words
     * @return
     */
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int length = words[0].length() * words.length;
        if (length > s.length()) {
            return result;
        }

        List<String> list = new ArrayList<>();
        List<String> array = new ArrayList<>(words.length);
        compositeStr(list, words, array, 0);
        System.out.println(list);

        return result;
    }

    public static void compositeStr(List<String> list, String[] words, List<String> array, int index) {
        if (array.size() == words.length) {
            list.add(Arrays.toString(array.toArray()));
            return;
        }

        for (int i = index; i < words.length; i++) {
            array.add(words[i]);
            compositeStr(list, words, array, array.size());
            array.remove(array.size() - 1);
        }
    }

    /**
     * 暴力破解
     * 遍历 s字符串
     *
     * 难点: 随机性: words 有多个字符串的时候, 将会有多种组合, 所以我们必须要知道所有排列组合然后做判断 (行不通, 列举次数多, 而且大多数都匹配不上, 并且容易重复)
     *
     * 所以我们不能以 words副字符串数组为准, 必需要以 s主字符串做文章
     *
     * 思路:
     * s(i) 当前位置, w(l) words 长度
     * 将每个 s(i - w(l))当作一个字串做判断, 如果相等, 当前位置 i则为一个有效答案
     *
     * 判断是否相同我们可以利用hashMap 做判断
     * 根据题意可知: 只要 words与 s的字串相同(不管顺序), 就属于有效答案
     *
     * 所以我们可以将每个 words存入 hashMap中
     * 键: words[i], 值: words[i] 出现的数量
     *
     * 其次我们还需要一个 map来存 s的子串, 逻辑相同, 截取相同长度的子串中的子串(s1.subString(0, words[0].length))存入map中, map中的数据同样是以之前的 map一样
     * 键: s1[i - words[0].length], 值: s1[i - words[0].length] 出现的数量
     * @param s
     * @param words
     * @return
     */
    public static List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        int wordLength = words[0].length();
        int wordNum = words.length;
        int totalNum = wordLength * wordNum;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }

        char[] sChars = s.toCharArray();
        for (int i = 0; i < sChars.length - totalNum + 1; i++) {
            String temp = s.substring(i, i + totalNum);
            HashMap<String, Integer> tempMap = new HashMap<>();
            for (int j = 0; j < totalNum; j += wordLength) {
                String t = temp.substring(j, j + wordLength);
                tempMap.put(t, tempMap.getOrDefault(t, 0) + 1);
            }

            if (map.equals(tempMap)) {
                result.add(i);
            }
        }

        return result;
    }

    /**
     * 滑动窗口(最优解)
     * @param s
     * @param words
     * @return
     */
    public static List<Integer> findSubstring3(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        int wordLength = words[0].length();
        int wordNum = words.length;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }

        for (int i = 0; i < wordLength; i++) {
            int left = i, right = i, count = 0;
            HashMap<String, Integer> tempMap = new HashMap<>();

            while (right + wordLength <= s.length()) {
                String str = s.substring(right, right + wordLength);
                tempMap.put(str, tempMap.getOrDefault(str, 0) + 1);
                right += wordLength;
                count++;
                while (tempMap.getOrDefault(str, 0) > map.getOrDefault(str, 0)) {
                    String tw = s.substring(left, left + wordLength);
                    count--;
                    tempMap.put(tw, tempMap.getOrDefault(tw, 0) - 1);
                    left += wordLength;
                }

                if (count == wordNum) {
                    result.add(left);
                }
            }
        }

        return result;
    }
}

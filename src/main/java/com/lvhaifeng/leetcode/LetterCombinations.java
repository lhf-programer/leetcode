package com.lvhaifeng.leetcode;

import java.util.*;

/**
 * @Description 电话号码的字母组合
 * @Author haifeng.lv
 * @Date 2021/9/1 15:52
 */
public class LetterCombinations {
    public static void main(String[] args) {
//        String digits = "23";
        String digits = "2345";
        List<String> list = letterCombinations(digits);
        System.out.println(list);
    }

    public static final Map<Integer, List<Character>> map = new HashMap<>();

    static {
        map.put(2, Arrays.asList('a', 'b', 'c'));
        map.put(3, Arrays.asList('d', 'e', 'f'));
        map.put(4, Arrays.asList('g', 'h', 'i'));
        map.put(5, Arrays.asList('j', 'k', 'l'));
        map.put(6, Arrays.asList('m', 'n', 'o'));
        map.put(7, Arrays.asList('p', 'q', 'r', 's'));
        map.put(8, Arrays.asList('t', 'u', 'v'));
        map.put(9, Arrays.asList('w', 'x', 'y', 'z'));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (null == digits || digits.length() == 0) {
            return result;
        }
        letterCombinations("", digits, result);
        return result;
    }

    public static void letterCombinations(String str, String digits, List<String> result) {
        List<Character> characters = map.get(Integer.parseInt(String.valueOf(digits.charAt(0))));
        if (digits.length() == 1) {
            for (Character character : characters) {
                result.add(str + character);
            }
        } else {
            for (Character character : characters) {
                letterCombinations(str + character, digits.substring(1), result);
            }
        }
    }
}

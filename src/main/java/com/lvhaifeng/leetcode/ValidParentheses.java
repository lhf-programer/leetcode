package com.lvhaifeng.leetcode;

import java.util.*;

/**
 * @Description 有效的括号
 * @Author haifeng.lv
 * @Date 2021/9/2 10:29
 */
public class ValidParentheses {
    public static void main(String[] args) {
//        String s = "()";
//        String s = "()[]{}";
//        String s = "(]";
//        String s = "([)]";
        String s = "{[]}";
        boolean valid = isValid(s);
        System.out.println(valid);
    }

    private static Map<Character, Character> map = new HashMap<>();
    static {
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
    }
    public static boolean isValid(String s) {
        if (null == s || s.length() == 1) {
            return false;
        }
        if (s.length() % 2 == 1) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        char[] sChars = s.toCharArray();

        for (int i = 0; i < sChars.length; i++) {
            if (null != map.get(sChars[i])) {
                stack.push(sChars[i]);
            } else {
                if (stack.empty() || map.get(stack.pop()) != sChars[i]) {
                    return false;
                }
            }
        }

        return stack.empty();
    }
}

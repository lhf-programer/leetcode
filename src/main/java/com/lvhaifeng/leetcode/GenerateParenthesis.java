package com.lvhaifeng.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 括号生成
 * @Author haifeng.lv
 * @Date 2021/9/2 11:45
 */
public class GenerateParenthesis {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
//        generateParenthesis(new char[3 * 2], 0, list);
        generateParenthesis(new StringBuilder(), 0, 0, 2, list);
        System.out.println(list);
    }

    /**
     * 暴力破解！
     * 先列出所有的可能答案
     * 会有 2 ^ (2 * n) 种答案
     * 再对结果进行校验是否正确
     *
     * @param chars
     * @param pos
     * @param list
     */
    public static void generateParenthesis(char[] chars, int pos, List<String> list) {
        if (chars.length == pos) {
            if (valid(chars)) {
                list.add(new String(chars));
            }
        } else {
            chars[pos] = '(';
            generateParenthesis(chars, pos + 1, list);
            chars[pos] = ')';
            generateParenthesis(chars, pos + 1, list);
        }
    }

    public static boolean valid(char[] chars) {
        int balance = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                balance++;
            } else {
                balance--;
            }

            if (balance < 0) {
                return false;
            }
        }

        return balance == 0;
    }

    /**
     * 回溯法
     * 根据最后字符串的结果来看, 具有的合法性有:
     * 长度一定为 n * 2
     * '(' 与 ')' 的数量一定相同
     * '(' 一定在前面
     * '(' 的数量不会大于 n
     *
     * 所以我们可以判断 '(' 的数量只要大于 n 就一直添加（在添加满后的回溯, 会进行删除）
     * ')' 的数量只要小于 '(' 的数量就一直添加 ')'（在添加满后的回溯, 会进行删除）
     *
     * @param stringBuilder
     * @param open
     * @param close
     * @param max
     * @param list
     */
    public static void generateParenthesis(StringBuilder stringBuilder, int open, int close, int max, List<String> list) {
        if (stringBuilder.length() == max * 2) {
            list.add(stringBuilder.toString());
            return;
        }

        if (open < max) {
            stringBuilder.append("(");
            generateParenthesis(stringBuilder, open + 1, close, max, list);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        if (open > close) {
            stringBuilder.append(")");
            generateParenthesis(stringBuilder, open, close + 1, max, list);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}

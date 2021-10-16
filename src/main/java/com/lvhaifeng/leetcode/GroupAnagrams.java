package com.lvhaifeng.leetcode;

import com.lvhaifeng.leetcode.utils.PrintArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 字母异位词分组
 * @Author haifeng.lv
 * @Date 2021/10/15 17:44
 */
public class GroupAnagrams {
    public static void main(String[] args) {
//        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] strs = {"dgg", "ddg"};
        List<List<String>> lists = groupAnagrams(strs);
        PrintArray.printArray(lists);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] array = new int[26];

            char[] chars = str.toCharArray();
            for (char c : chars) {
                array[c - 'a']++;
            }

            StringBuilder key = new StringBuilder();
            for (int i = 0; i < array.length; i++) {
                if (array[i] != 0) {
                    key.append(i + 'a');
                    key.append(array[i]);
                }
            }

            List<String> list = map.getOrDefault(key.toString(), new ArrayList<>());
            list.add(str);
            map.put(key.toString(), list);
        }

        return new ArrayList<>(map.values());
    }
}

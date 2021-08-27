package com.lvhaifeng.leetcode.utils;

/**
 * @Description
 * @Author haifeng.lv
 * @Date 2021/8/25 18:31
 */
public class PrintArray {
    public static void printArray(int[][] objects) {
        System.out.println();
        for (int k = 0; k < objects.length; k++) {
            for (int l = 0; l < objects[k].length; l++) {
                System.out.printf(objects[k][l] + "\t");
            }
            System.out.println();
        }
    }

    public static void printArray(boolean[][] objects) {
        System.out.println();
        for (int k = 0; k < objects.length; k++) {
            for (int l = 0; l < objects[k].length; l++) {
                System.out.printf((objects[k][l] ? 1 : 0) + "\t");
            }
            System.out.println();
        }
    }
}

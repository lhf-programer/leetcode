package com.lvhaifeng.leetcode;

/**
 * @Description Z 字形变换
 * @Author haifeng.lv
 * @Date 2021/8/24 9:36
 */
public class ZTransformation {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        Integer num = 4;

        String convert = convert(s, num);
        System.out.println("Z 字形结果: " + convert);
    }

    /**
     * 自己写的垃圾
     *
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (numRows == 1) {
            return s;
        }
        if (s.length() <= numRows) {
            return s;
        }

        String temp = "";
        /**
         * 计算列长
         * 由最终效果图可以看出来
         * 我们的每个 'Z' 的高度为 numRows, 我们去除 'Z' 字最后一行可以得知 numRows - 1 可以拼成一个没有最后一行的 'Z' 也就是这样的效果:
         * P
         * A P
         * Y
         * 最终的二维数组也是由改图形演变而来
         * 核心思路为 (s.length() / (numRows + numRows - 2)) * (numRows - 1)
         * s.length() / (numRows + numRows - 2): 总长度除以行数 - 2 我就可以得知会有几个 (没有最后一行的 'Z'), 例子: 14 / (3 + 3 - 2)
         * numRows - 1 就可以得知 (没有最后一行的 'Z') 的列宽 例子: 2 = (3 - 1)
         *
         * 完整案列: (14 / (3 + 3 - 2)) * (3 - 1) = 6
         *
         * 但是由于 14 / (3 + 3 - 2) 无法做到整除
         * 我们可以将余数算出再做处理
         * 如果大于 numRows 则为 (s.length() % (numRows + numRows - 2)) - numRows + 1 (这样做的意义为后面的每一个数字都可以占一列)
         * 如果小于 numRows 则为 1行
         *
         * 所以最终行数为 7行
         * (14 / (3 + 3 - 2)) * (3 - 1) + 1 = 7
         */
        int column = s.length() % (numRows + numRows - 2) > 0 ? ((s.length() / (numRows + numRows - 2) * (numRows - 1)) +
                (s.length() % (numRows + numRows - 2) > numRows ? (s.length() % (numRows + numRows - 2)) - numRows + 1 : 1)) : (s.length() / (numRows + numRows - 2)) * (numRows - 1);
        System.out.println("列长: " + column);

        char[][] chars = new char[numRows][column];
        int j = 0;
        // 以列为递进单位进行填充
        for (int i = 0; i < column; i++) {
            if (i % (numRows - 1) > 0 && j < s.length()) {
                chars[numRows - (i % (numRows - 1)) - 1][i] = s.charAt(j);
                j++;
            } else {
                for (int k = 0; k < numRows; k++) {
                    if (j < s.length()) {
                        chars[k][i] = s.charAt(j);
                        j++;
                    }
                }
            }
        }

        System.out.println();
        for (int k = 0; k < chars.length; k++) {
            for (int l = 0; l < chars[k].length; l++) {
                System.out.printf(chars[k][l] + "\t");
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 0; i < chars.length; i++) {
            for (int k = 0; k < chars[i].length; k++) {
                if (chars[i][k] != 0) {
                    temp += chars[i][k];
                }
            }
        }

        return temp;
    }
}

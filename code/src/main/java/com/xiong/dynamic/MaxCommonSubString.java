package com.xiong.dynamic;

/**
 * 最长公共子串
 */
public class MaxCommonSubString {

    public static void cal1(String a, String b) {
        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();

        int[][] m = new int[ca.length + 1][cb.length + 1];
        int k = 0;
        for (int i = 0; i <= ca.length; i++) {
            m[i][0] = 0;
        }
        for (int i = 0; i <= cb.length; i++) {
            m[0][i] = 0;
        }

        int max = 0;
        for (int i = 1; i <= ca.length; i++) {
            for (int j = 1; j <= cb.length; j++) {
                if (ca[i - 1] == cb[j - 1]) {
                    m[i][j] = m[i - 1][j - 1] + 1;
                } else {
                    m[i][j] = 0;
                }
                if (m[i][j] > max) {
                    k = i;
                    max = m[i][j];
                }
            }
        }
        System.out.println(max);
        System.out.println(new String(ca, k - max, max));
    }

    public static void main(String[] args) {
        String a = "abcdef";
        String b = "badef";
        cal1(a, b);
    }
}

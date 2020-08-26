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

    public static void cal2(String a, String b) {
        char[] charA = a.toCharArray();
        char[] charB = b.toCharArray();
        int lenA = charA.length;
        int lenB = charB.length;
        int[][] m = new int[lenA + 1][lenB + 1];

        for (int i = 0; i <= lenA; i++) {
            m[i][0] = 0;
        }

        for (int i = 0; i <= lenB; i++) {
            m[0][i] = 0;
        }

        int max = 0;
        int indexA = -1;
        int indexB = -1;
        for (int i = 1; i <= lenA; i++) {
            for (int j = 1; j <= lenB; j++) {
                if (charA[i - 1] == charB[j - 1]) {
                    m[i][j] = m[i - 1][j - 1] + 1;
                } else {
                    m[i][j] = 0;
                }
                if (m[i][j] > max) {
                    max = m[i][j];
                    indexA = i;
                    indexB = j;
                }
            }
        }

        System.out.println("长度" + max);

        System.out.println("第一个字符串" + (indexA - max + 1) + "," + indexA);
        System.out.println("第二个字符串" + (indexB - max + 1) + "," + indexB);
    }

    public static void main(String[] args) {
        String a = "abcdef";
        String b = "badef";
        cal1(a, b);
        System.out.println("--------2------------");
        cal2(a, b);
    }
}

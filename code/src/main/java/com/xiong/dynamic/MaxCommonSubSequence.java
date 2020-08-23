package com.xiong.dynamic;

/**
 * 最长公共子序列问题
 */
public class MaxCommonSubSequence {
    public static void cal1(String a, String b) {
        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();

        int na = ca.length;
        int nb = cb.length;

        int[][] m = new int[na + 1][nb + 1];
        int[][] s = new int[na + 1][nb + 1];
        for (int i = 0; i <= na; i++) {
            m[i][0] = 0;
        }
        for (int i = 0; i <= nb; i++) {
            m[0][nb] = 0;
        }

        for (int i = 1; i <= na; i++) {
            for (int j = 1; j <= nb; j++) {
                if (ca[i - 1] == cb[j - 1]) {
                    m[i][j] = m[i - 1][j - 1] + 1;
                    s[i][j] = 1;
                } else {
                    if (m[i][j - 1] > m[i - 1][j]) {
                        m[i][j] = m[i][j - 1];
                        s[i][j] = 2;
                    } else {
                        m[i][j] = m[i - 1][j];
                        s[i][j] = 3;
                    }
                }
            }
        }
        track1(s, ca, na, nb, "");
        System.out.println(m[na][nb]);
    }

    private static void track1(int[][] s, char[] a, int na, int nb, String t) {
        if (na != 0 && nb != 0) {
            if (s[na][nb] == 1) {
                t = a[na - 1] + t;
            }
            if (s[na][nb] == 2) {
                track1(s, a, na, nb - 1, t);
            } else {
                track1(s, a, na - 1, nb, t);
            }
        } else {
            System.out.println("最长公共子序列为:" + t);
        }
    }

    public static void main(String[] args) {
        String a = "ace";
        String b = "abce";
        cal1(a, b);
    }
}

package com.xiong.dynamic;

/**
 * 0-1背包问题
 */
public class ZeroOneBag {
    public static void cal1(int[] v, int[] w, int c) {
        int n = v.length;
        int[][] m = new int[n + 1][c + 1];
        int[][] s = new int[n + 1][c + 1];
        for (int i = 0; i <= c; i++) {
            m[0][i] = 0;
        }

        for (int i = 0; i <= n; i++) {
            m[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= c; j++) {
                if (w[i - 1] > j) {
                    m[i][j] = m[i - 1][j];
                } else {
                    int not = m[i - 1][j];
                    int yew = m[i - 1][j - w[i - 1]] + v[i - 1];
                    if (not >= yew) {
                        m[i][j] = not;
                        s[i][j] = 0;
                    } else {
                        m[i][j] = yew;
                        s[i][j] = 1;
                    }
                }
            }
        }

        System.out.println("最大价值为:" + m[n][c]);

        int k = n;
        int a = c;
        while (k >= 1) {
            System.out.println("第" + k + "个" + (s[k][a] == 1 ? "选" : "不选"));
            if (s[k][a] == 0) {
                k--;
            } else {
                a = a - w[k - 1];
                k--;
            }
        }
    }


    public static void cal2(int[] v, int[] w, int c) {
        int n = v.length; // 商品种树
        int[][] m = new int[n + 1][c + 1];
        int[][] s = new int[n + 1][c + 1];
        for (int i = 0; i <= c; i++) {
            m[0][i] = 0;
        }
        for (int i = 0; i <= n; i++) {
            m[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= c; j++) {
                if (w[i - 1] > j) {
                    m[i][j] = m[i - 1][j];
                } else {
                    int putValue = m[i - 1][j - w[i - 1]] + v[i - 1];
                    int notPutValue = m[i - 1][j];
                    if (putValue > notPutValue) {
                        m[i][j] = putValue;
                        s[i][j] = 1;
                    } else {
                        m[i][j] = notPutValue;
                        s[i][j] = 0;
                    }
                }
            }
        }

        System.out.println(m[n][c]);

        trace2(s, w, c, n);

    }

    public static void trace2(int[][] s, int[] w, int c, int i) {
        if (i > 0) {
            System.out.println(i + (s[i][c] == 1 ? "选择" : "不选"));
            if (s[i][c] == 1) {
                c = c  - w[i-1];
            }
            trace2(s, w, c, --i);
        }
    }

    public static void main(String[] args) {
        int[] v = {6, 3, 5, 4, 6};
        int[] w = {2, 2, 6, 5, 4};
        cal1(v, w, 10);
        System.out.println("--------2---------");
        cal2(v, w, 10);
    }
}

package com.xiong.dynamic;

/**
 * 矩阵连乘问题
 */
public class MatrixChain {
    public static void cal(int[] matrix) {
        int n = matrix.length - 1; // 一共有这么多矩阵
        int[][] x = new int[n + 1][n + 1];
        int[][] s = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            x[i][i] = 0;
        }

        for (int step = 2; step <= n; step++) {
            for (int k = 1; k <= n - step + 1; k++) {
                int min = Integer.MAX_VALUE;
                int j = k + step - 1;
                for (int p = k; p < j; p++) {
                    int t = x[k][p] + x[p + 1][j] + matrix[k - 1] * matrix[p] * matrix[j];
                    if (t < min) {
                        s[k][j] = p;
                        min = t;
                    }
                }
                x[k][j] = min;
            }
        }
        track(s, 1, n);
        System.out.println(x[1][n]);
    }

    private static void track(int[][] s, int i, int n) {
        if (i < n) {
            System.out.println(i + "->" + n + "：" + s[i][n]);
            track(s, i, s[i][n] - 1);
            track(s, s[i][n] + 1, n);
        }
    }


    private static void cal2(int[] m) {
        int n = m.length - 1; // 矩阵个数
        int[][] x = new int[n][n]; // 记录第i个矩阵 到第j个矩阵相乘最少乘的次数

        for (int i = 0; i < n; i++) {
            x[i][i] = 0;
        }
        for (int step = 2; step <= n; step++) {
            for (int i = 0; i <= n - step; i++) {
                int min = Integer.MAX_VALUE;
                int j = i + step - 1;

                for (int k = i; k < j; k++) {
                    int t = x[i][k] + x[k + 1][j] + m[i] * m[k + 1] * m[j + 1];
                    if (t < min) {
                        min = t;
                    }
                }
                x[i][j] = min;
            }
        }

        System.out.println(x[0][n - 1]);
    }


    public static void cal3(int[] x) {
        int n = x.length - 1; // 表示有多少个矩阵相乘
        int[][] m = new int[n + 1][n + 1];  // 用下标1表示第一个矩阵

        for (int i = 0; i <= n; i++) {
            m[i][i] = 0;
        }

        for (int step = 2; step <= n; step++) {
            for (int left = 1; left <= n - step + 1; left++) {
                int right = left + step - 1;
                m[left][right] = Integer.MAX_VALUE;
                for (int k = left; k < right; k++) {
                    int t = m[left][k] + m[k + 1][right] + x[left - 1] * x[k] * x[right];
                    if (t < m[left][right]) {
                        m[left][right] = t;
                    }
                }
            }
        }

        System.out.println(m[1][n]);
    }

    public static void main(String[] args) {
        int[] matrix = {10, 100, 5, 50};
        int[] matrix2 = {30, 35, 15, 5, 10, 20, 25};
        cal(matrix2);
        cal2(matrix2);
        cal3(matrix2);
    }
}

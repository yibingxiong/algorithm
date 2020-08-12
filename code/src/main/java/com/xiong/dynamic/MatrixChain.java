package com.xiong.dynamic;

public class MatrixChain {
    public static void cal(int[] matrix) {
        int n = matrix.length - 1; // 一共有这么多矩阵
        int[][] x = new int[n + 1][n + 1];

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
                        min = t;
                    }
                }
                x[k][j] = min;
            }
        }

        System.out.println(x[1][n]);
    }

    public static void main(String[] args) {
        int[] matrix = {10, 100, 5, 50};
        int[] matrix2 = {30, 35, 15, 5, 10, 20, 25};
        cal(matrix2);
    }
}

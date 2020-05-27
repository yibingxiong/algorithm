package topic.dynamic;

/**
 * 求解：计算n个矩阵相乘的最少乘的次数，及乘的方式
 * <p>
 * 这n个矩阵{A1, A2, ...,An}的尾数分别为p0 x p1, p1*p2  pn-1 * pn
 * 所以这n个矩阵可以用一个包含n+1个元素的数组p表示，例如p={1,2,3} 表示2个矩阵相乘
 * 矩阵1 1*2  矩阵2 2*3
 */
public class MatrixMultiplication {
    public static void calcute(int[] p) {
        int n = p.length - 1;   // 矩阵个数
        int[][] m = new int[n + 1][n + 1];  // m[i][j]表示第i个矩阵到第j个矩阵最少乘的次数，从1开始
        int[][] s = new int[n + 1][n + 1]; // s[i][j]表示第i个矩阵到第j个矩阵取得最少乘的次数时，断开的位置

        for (int i = 1; i <= n; i++) {
            m[i][i] = 0;
        }
        for (int r = 2; r <= n; r++) {
            for (int i = 1; i <= n - r + 1; i++) {
                int j = i + r - 1;
                m[i][j] = m[i + 1][j] + p[i - 1] * p[i] * p[j];
                s[i][j] = i;
                for (int k = i + 1; k < j; k++) {
                    int t = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (t < m[i][j]) {
                        m[i][j] = t;
                        s[i][j] = k;
                    }
                }
            }
        }
        System.out.println(m[1][n]);
    }


    public static void main(String[] args) {
        int[] p = {10, 100, 5, 50};
        calcute(p);
    }
}

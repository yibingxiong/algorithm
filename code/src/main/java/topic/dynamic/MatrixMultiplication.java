package topic.dynamic;

import java.util.Random;

/**
 * 求解：计算n个矩阵相乘的最少乘的次数，及乘的方式
 * <p>
 * 这n个矩阵{A1, A2, ...,An}的尾数分别为p0 x p1, p1*p2  pn-1 * pn
 * 所以这n个矩阵可以用一个包含n+1个元素的数组p表示，例如p={1,2,3} 表示2个矩阵相乘
 * 矩阵1 1*2  矩阵2 2*3
 */
public class MatrixMultiplication {
    private static int calculate(int[] p) {
        if (p.length < 2) {
            return 0;
        }
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
        return m[1][n];
    }

    private static int calculate2(int[] p) {
        if (p.length < 2) {
            return 0;
        }
        int n = p.length - 1; // 矩阵个数
        int[][] m = new int[n][n];

        for (int i = 0; i < n; i++) {
            m[i][i] = 0;
        }

        for (int r = 2; r <= n; r++) {
            for (int i = 0; i <= n - r; i++) {
                int j = i + r - 1;
                m[i][j] = m[i + 1][j] + p[i] * p[i + 1] * p[j + 1];
                for (int k = i + 1; k < j; k++) {
                    int t = m[i][k] + m[k + 1][j] + p[i] * p[k + 1] * p[j + 1];
                    if (t < m[i][j]) {
                        m[i][j] = t;
                    }
                }
            }
        }

        return m[0][n - 1];
    }

    public static int cal3(int[] p) {
        if (p.length < 2) {
            System.out.println("不能构成一个矩阵");
            return 0;
        }
        if (p.length == 2) {
            return 0;
        }
        int count = p.length - 1;
        int[][] m = new int[count][count];

        for (int i = 0; i < count; i++) {
            m[i][i] = 0;
        }
        // 矩阵下标是 0 ， 1,....  count-1,  矩阵i  p(i) * p(i+1)
        for (int s = 2; s <= count; s++) {
            for (int i = 0; i <= count - s; i++) {
                int j = i + s - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int t = m[i][k] + m[k + 1][j] + p[i] * p[k + 1] * p[j + 1];
                    if (t < m[i][j]) {
                        m[i][j] = t;
                    }
                }
            }
        }
        return m[0][count - 1];
    }

    public static int[] generateArray(int n) {
        int[] res = new int[n];
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < n; i++) {
            res[i] = random.nextInt(100) + 2;
        }
        return res;
    }

    public static int[] copy(int[] source) {
        int[] res = new int[source.length];
        for (int i = 0; i < source.length; i++) {
            res[i] = source[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < 1000; i++) {
            int[] array = generateArray(random.nextInt(100) + 1);
            int[] arr1 = copy(array);
            int[] arr2 = copy(array);
            int[] arr3 = copy(array);

            System.out.println("输入：");
            for (int j = 0; j < arr1.length; j++) {
                System.out.print(arr1[j] + ",");
            }
            System.out.println();
            int res1 = calculate(arr1);
            int res2 = calculate2(arr2);
            int res3 = cal3(arr3);
            if (res1 != res2 || res1 != res3) {
                System.out.println("1:" + res1);
                System.out.println("2:" + res2);
                System.out.println("3:" + res3);
                break;
            } else {
                System.out.println("pass:" + i);
            }
        }
    }
}

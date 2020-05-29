package topic.dynamic;

/**
 * 最长公共子序列问题
 */
public class A_02Lcs {
    public static int cal1(char[] a, char[] b) {
        int Na = a.length;
        int Nb = b.length;
        int[][] m = new int[Na + 1][Nb + 1];
        byte[][] s = new byte[Na+1][Nb+1];
        for (int i = 0; i <= Nb; i++) {
            m[0][i] = 0;
        }
        for (int i = 0; i <= Na; i++) {
            m[i][0] = 0;
        }
        for (int i = 1; i <= Na; i++) {
            for (int j = 1; j <= Nb; j++) {
                if (a[i-1] == b[j-1]) {
                    m[i][j] = m[i - 1][j - 1] + 1;
                    s[i][j] = 0
                    ;
                } else {
                    int t1 = m[i - 1][j];
                    int t2 = m[i][j - 1];
                    if (t1 < t2) {
                        m[i][j] = t2;
                        s[i][j] = 2;
                    } else {
                        m[i][j] = t1;
                        s[i][j] = 1;
                    }
                }
            }
        }
        track(a,b,s,Na, Nb);
        return m[Na][Nb];
    }

    public static void track(char[] a, char[] b, byte[][] s, int i, int j) {
        if (i==0 || j==0) {
            return;
        }
        if (s[i][j] == 0) {
            System.out.println(a[i-1]);
            track(a,b,s,i-1,j-1);
        } else if (s[i][j] == 2) {
            track(a,b,s,i-1,j);
        } else {
            track(a,b,s,i,j-1);
        }
    }

    public static void main(String[] args) {
        char[] a = "ABCBDAB".toCharArray();
        char[] b = "BDCABA".toCharArray();
        int res1 = cal1(a, b);
        System.out.println("res1=" + res1);
    }
}

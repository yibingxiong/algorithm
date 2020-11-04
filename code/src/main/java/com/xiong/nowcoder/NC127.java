package com.xiong.nowcoder;

public class NC127 {
    public static class Solution {
        /**
         * longest common substring
         *
         * @param str1 string字符串 the string
         * @param str2 string字符串 the string
         * @return string字符串
         */
        public String LCS(String str1, String str2) {
            if (str1 == null || str2 == null) {
                return "-1";
            }
            // write code here
            int m = str1.length();
            int n = str2.length();
            int[][] r = new int[m + 1][n + 1];

            for (int i = 0; i <= m; i++) {
                r[i][0] = 0;
            }
            for (int i = 0; i <= n; i++) {
                r[0][i] = 0;
            }

            int max = -1;
            int idx = 0;
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                        int k = r[i - 1][j - 1] + 1;
                        r[i][j] = k;
                        if (k > max) {
                            max = k;
                            idx = j;
                        }

                    } else {
                        r[i][j] = 0;
                    }
                }
            }
            if (max == -1) {
                return "-1";
            }
            return str2.substring(idx - max, idx);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str1 = "1AB2uuu3rrrr45aC6D";
        String str2 = "12345aE6F";

        System.out.println(solution.LCS(str1, str2));

    }
}

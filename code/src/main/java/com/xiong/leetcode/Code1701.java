package com.xiong.leetcode;

public class Code1701 {
    static class Solution {
        public int waysToStep(int n) {
            long[] h = new long[n + 1];
            if (n == 0) {
                return 0;
            }
            if (n == 1) {
                return 1;
            }
            if (n == 2) {
                return 2;
            }
            if (n == 3) {
                return 4;
            }
            h[0] = 0;
            h[1] = 1;
            h[2] = 2;
            h[3] = 4;
            if (n <= 3) {
                return (int) h[n];
            }

            for (int i = 4; i <= n; i++) {
                h[i] = (h[i - 1] + h[i - 2] + h[i - 3]) % 1000000007;
            }
            return (int) (h[n]);
        }
    }

    public static void main(String[] args) {
        int i = new Solution().waysToStep(5);
        System.out.println(i);
    }
}

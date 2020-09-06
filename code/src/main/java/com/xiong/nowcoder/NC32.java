package com.xiong.nowcoder;

public class NC32 {
    public class Solution {
        /**
         * @param x int整型
         * @return int整型
         */
        public int sqrt(int x) {
            int left = 0;
            int right = x;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (mid * mid > x - 1 && mid * mid <= x) {
                    return mid;
                } else if (mid * mid > x) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return (int) Math.sqrt(x);
        }
    }

    public static void main(String[] args) {

    }
}

package com.xiong.leetcode;

public class Code374 {
    /**
     * Forward declaration of guess API.
     *
     * @return -1 if num is lower than the guess number
     * 1 if num is higher than the guess number
     * otherwise return 0
     * ;
     */

    public class Solution {
        int guess(int num) {
            return 0;
        }

        public int guessNumber(int right) {
            int left = 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (guess(mid) == 0) {
                    return mid;
                } else if (guess(mid) < 0) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return Integer.MAX_VALUE;
        }
    }
}

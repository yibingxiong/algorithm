package com.xiong.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Code390 {
    static class Solution {
        private int a;

        public int lastRemaining(int n) {
            boolean flag = false;
            int res = 1;
            int step = 1;
            int num = n;
            while (res + step <= n) {
                if (num % 2 == 0) {
                    res = flag == false ? (res + step) : res;
                } else {
                    res += step;
                }
                step = step * 2;
                flag = !flag;
                num = num / 2;
            }
            return res;
        }

    }

    public static void main(String[] args) {

        int i = new Solution().lastRemaining(9);
        System.out.println("33331ff" + i);
    }
}

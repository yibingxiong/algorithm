package com.xiong.nowcoder;

import java.util.Arrays;

/**
 * TODO: 通过了，但是没有找到一个符合O(n)要求的算法
 */
public class NC30 {
    public class Solution {
        /**
         * return the min number
         * 挺可怕，空间O1， 时间O(n) 没想到啊。。。。。。
         *
         * @param arr int整型一维数组 the array
         * @return int整型
         */
        public int minNumberdisappered(int[] arr) {
            // write code here
            if (arr == null || arr.length == 0) {
                return 1;
            }
            Arrays.sort(arr); // 这一步是O(nlogn)的 ， 空间能做到O(1)
            int i = 0;
            while (i < arr.length) {
                if (arr[i] > 0) {
                    if (i == 0) {
                        if (arr[i] != 1) {
                            return 1;
                        }
                    } else {
                        if (arr[i] - arr[i - 1] > 1) {
                            return arr[i] - 1;
                        }
                    }
                    i++;
                } else {
                    i++;
                }
            }
            return arr[arr.length - 1] + 1;
        }
    }
}

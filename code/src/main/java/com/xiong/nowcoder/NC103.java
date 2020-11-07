package com.xiong.nowcoder;

public class NC103 {
    public class Solution {
        /**
         * 反转字符串 方法1使用额外空间 空间复杂度O(n) ,时间复杂度O(n)
         *
         * @param str string字符串
         * @return string字符串
         */
        public String solve2(String str) {
            // write code here
            StringBuilder sb = new StringBuilder();
            for (int i = str.length() - 1; i >= 0; i--) {
                sb.append(str.charAt(i));
            }
            return sb.toString();
        }

        /**
         * 反转字符串 方法2 空间复杂度O(n), 时间复杂度O(n/2)
         *
         * @param str string字符串
         * @return string字符串
         */
        public String solve(String str) {
            // write code here
            if (str == null || str.length() <= 1) {
                return str;
            }
            char[] chars = str.toCharArray();
            int i = 0;
            int j = chars.length - 1;
            while (i < j) {
                swap(chars, i++, j--);
            }
            return new String(chars);
        }

        private void swap(char[] str, int i, int j) {
            char t = str[i];
            str[i] = str[j];
            str[j] = t;
        }
    }
}

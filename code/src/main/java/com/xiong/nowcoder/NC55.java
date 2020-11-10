package com.xiong.nowcoder;

public class NC55 {
    public class Solution {
        /**
         * @param strs string字符串一维数组
         * @return string字符串
         */
        public String longestCommonPrefix(String[] strs) {
            // write code here
            int i = 0;
            if (strs == null) {
                return null;
            }
            if (strs.length == 0) {
                return "";
            }
            if (strs.length == 1) {
                return strs[0];
            }

            while (i < strs[0].length()) {
                char t = strs[0].charAt(i);
                boolean eq = true;
                for (int j = 1; j < strs.length; j++) {
                    String str = strs[j];
                    if (str.length() <= i) {
                        eq = false;
                        break;
                    }
                    if (strs[j].charAt(i) != t) {
                        eq = false;
                        break;
                    }
                }
                if (eq) {
                    i++;
                } else {
                    break;
                }
            }
            return strs[0].substring(0, i);
        }
    }
}

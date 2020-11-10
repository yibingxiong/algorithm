package com.xiong.nowcoder;

public class NC57 {
    public class Solution {
        /**
         * @param x int整型
         * @return int整型
         */
        public int reverse(int x) {
            // write code here
            int t = Math.abs(x);
            char[] chars = String.valueOf(t).toCharArray();

            int i = 0;
            int j = chars.length - 1;

            while (i < j) {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
            }
            int preZero = 0;
            for (i = 0; i < chars.length; i++) {
                if (chars[i] == '0') {
                    preZero++;
                } else {
                    break;
                }
            }
            String str = new String(chars, preZero, chars.length - preZero);
            if (str.equals("")) {
                return 0;
            }
            int k = Integer.valueOf(str);

            if (k < 0) {
                throw new RuntimeException();
            }
            return x < 0 ? -k : k;

        }
    }
}

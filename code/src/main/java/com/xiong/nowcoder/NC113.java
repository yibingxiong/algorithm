package com.xiong.nowcoder;

import java.util.regex.Pattern;

public class NC113 {
    public class Solution {
        /**
         * 验证IP地址
         * @param IP string字符串 一个IP地址字符串
         * @return string字符串
         */
        public String solve (String IP) {
            // write code here
            if (IP == null) {
                return "Neither";
            }
            if (IP.contains(".")) {
                if (isIPV4(IP)) {
                    return "IPv4";
                } else {
                    return "Neither";
                }
            }

            if (isIPV6(IP)) {
                return "IPv6";
            } else {
                return "Neither";
            }

        }

        private boolean isIPV4(String ip) {
            String[] strs= ip.split("\\.");
            if (strs.length!=4) {
                return false;
            }
            for (int i = 0; i< strs.length; i++) {
                String str = strs[i];
                if (str.indexOf("0") == 0) {
                    return false;
                }
                int k = Integer.parseInt(str);
                if ( k < 0 || k> 255) {
                    return false;
                }
            }
            return true;
        }

        private boolean isIPV6(String ip) {
            String[] strs= ip.split(":");
            if (strs.length != 8) {
                return false;
            }
            for (int i = 0; i< strs.length; i++) {
                String str = strs[i];
                if (str.indexOf("::") > -1) {
                    return false;
                }
                if (str.matches("^0+$") && !"0".equals(str)) {
                    return false;
                }
                str = str.toLowerCase();
                for (int j = 0; j < str.length(); j++) {
                    boolean f = (str.charAt(j) >= '0' && str.charAt(j) <= '9') || ((str.charAt(j) >='a' && str.charAt(j) <='f'));
                    if (!f) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}

package com.xiong.leetcode;

import java.util.HashMap;

public class Code383 {
    static class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            HashMap<Character, Integer> hashMap = new HashMap<>();
            char[] chars = magazine.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (hashMap.containsKey(chars[i])) {
                    hashMap.put(chars[i], hashMap.get(chars[i]) + 1);
                } else {
                    hashMap.put(chars[i], 1);
                }
            }

            for (int i = 0; i < ransomNote.length(); i++) {
                char n = ransomNote.charAt(i);
                if (hashMap.containsKey(n)) {
                    Integer integer = hashMap.get(n);
                    if (integer > 0) {
                        hashMap.put(n, integer - 1);
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        new Solution().canConstruct("aa", "aab");
    }
}

package com.xiong.nowcoder;

import java.util.HashMap;
import java.util.Stack;

public class NC52 {
    public class Solution {
        /**
         * @param s string字符串
         * @return bool布尔型
         */
        public boolean isValid(String s) {
            // write code here
            Stack<Character> stack = new Stack<>();
            if (s == null) {
                return true;
            }
            HashMap<Character, Character> map = new HashMap<>();
            map.put('(', ')');
            map.put('[', ']');
            map.put('{', '}');
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (c == '}' || c == ']' || c == ')') {
                    if (stack.isEmpty()) {
                        return false;
                    } else {
                        char p = stack.pop();
                        if (map.get(p) != c) {
                            return false;
                        }
                    }
                } else {
                    stack.push(c);
                }
            }
            return stack.isEmpty();
        }
    }
}

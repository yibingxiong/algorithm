package leetcode.stack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class Code00020 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        if (s == null || s.equals("")) {
            return true;
        }
        char[] characters = s.toCharArray();
        if(characters.length%2!=0) {
            return false;
        }
        stack.push(characters[0]);

        HashMap<Character, Character> rightLeftMap = new HashMap<Character, Character>();
        rightLeftMap.put(')', '(');
        rightLeftMap.put(']', '[');
        rightLeftMap.put('}', '{');
        for (int i = 1; i < characters.length; i++) {
            Character a = characters[i];
            if (rightLeftMap.containsKey(a)) {
                if(stack.isEmpty()) {
                    return false;
                }
                Character b = stack.pop();
                if (rightLeftMap.get(a) != b) {
                    return false;
                }
            } else {
                stack.push(a);
            }
        }

        return stack.isEmpty();
    }
}

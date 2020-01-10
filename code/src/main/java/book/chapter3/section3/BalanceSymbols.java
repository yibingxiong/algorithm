package book.chapter3.section3;

public class BalanceSymbols {
    public boolean isBalance(String str) {
        return isBalance(str.toCharArray());
    }

    public boolean isBalance(char[] chars) {
        MyStack<Character> stack = new MyStack<Character>();

        int i = 0;
        while (i < chars.length) {
            char c = chars[i];
            i++;
            if (c == '[' || c == '{' || c == '(') {
                stack.push(c);
            } else if (c == ']' || c == '}' || c == ')') {
                char stackTop = stack.pop();
                if (stackTop == '[' && c == ']') {
                    continue;
                }
                if (stackTop == '(' && c == ')') {
                    continue;
                }
                if (stackTop == '{' && c == '}') {
                    continue;
                }
                return false;
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}

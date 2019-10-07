package leetcode;

import java.util.ArrayDeque;

public class Code020_isValid {
	
	public static boolean isLeft(char c) {
		if (c == '[' || c == '{' || c == '(') {
			return true;
		}
		return false;
	}

	public static char getPipei(char c) {
		switch (c) {
		case '[':
			return ']';
		case '{':
			return '}';
		case '(':
			return ')';
		default:
			return ' ';
		}
	}

	public static boolean isValid(String s) {
		if (s.length() == 0) {
			return true;
		}
		if (s.length() % 2 == 1) {
			return false;
		}
		ArrayDeque<Character> stack = new ArrayDeque<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (isLeft(c)) {
				stack.push(c);
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				char top = stack.pop();
				if (c != getPipei(top)) {
					return false;
				}

			}
		}
		if (!stack.isEmpty()) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isValid("()[]{}"));
		System.out.println(isValid("()"));
		System.out.println(isValid("(]"));
		System.out.println(isValid("{()}"));
		System.out.println(isValid("{()"));

		ArrayDeque<Integer> a = new ArrayDeque<>();
		a.push(1);
		a.push(2);
		System.out.println(a.pop());
		System.out.println(a);

	}

}

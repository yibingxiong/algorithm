package leetcode;

import java.util.ArrayDeque;

public class Code1021_removeOuterParentheses {

	public static String removeOuterParentheses(String S) {
		ArrayDeque<String> stack = new ArrayDeque<>();
		String res = "";
		for (int i = 0; i< S.length();i++) {
			String c = Character.toString(S.charAt(i));
			if(!stack.isEmpty() && !(c.equals(")") && stack.size()==1)) {
				res+=c;
			}
			if(c.equals(")")) {
				stack.pop();
			} else {
				stack.push(c);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(removeOuterParentheses("(()())(())(()(()))"));
	}

}

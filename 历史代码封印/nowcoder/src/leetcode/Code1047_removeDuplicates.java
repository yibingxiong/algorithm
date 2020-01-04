package leetcode;

import java.util.ArrayDeque;

public class Code1047_removeDuplicates {

	public static String removeDuplicates(String S) {
		ArrayDeque<String> stack = new ArrayDeque<>();
		
		for(int i = 0; i< S.length(); i++) {
			String ss = Character.toString(S.charAt(i));
			
			if (!stack.isEmpty() && stack.peek().equals(ss)) {
				stack.pop();
			} else {
				stack.push(ss);
			}
		}
		
		String res = "";
		
		while(!stack.isEmpty()) {
			res += stack.removeLast();
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(removeDuplicates("abbaca"));
	}

}

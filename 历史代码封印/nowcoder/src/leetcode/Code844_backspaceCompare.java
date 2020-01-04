package leetcode;

import java.util.ArrayDeque;

public class Code844_backspaceCompare {

	public static String getReqlStr(String s) {
		ArrayDeque<Character> stack = new ArrayDeque<>();
		
		for(int i = 0; i<s.length(); i++) {
			if (s.charAt(i)!='#') {
				stack.push(s.charAt(i));
			} else {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			}
		}
		char[] cs = new char[stack.size()];
		int i = 0;
		while(!stack.isEmpty()) {
			cs[i++] = stack.poll();
		}
		
		return new String(cs);
		
	}
	public static boolean backspaceCompare(String S, String T) {
		S = getReqlStr(S);
		T = getReqlStr(T);
		
		return S.equals(T);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

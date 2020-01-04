package leetcode;

import java.util.LinkedList;
import java.util.Stack;

public class Code009_IsPalindrome {

	public static boolean isPalindrome(int x) {
		if (x < 10 && x >= 0) {
			return true;
		}
		if (x < 0 || x == 10) {
			return false;
		}
		int k = 0;
		while (Math.pow(10, k) < x) {
			k++;
		}
		k--;
		int pre = 0;
		Stack<Integer> s = new Stack<>();
		LinkedList<Integer> ls = new LinkedList<>();
		while (k > 0) {
			int m = (int) Math.floor(((x - pre) / Math.pow(10, k--)));
			pre += m * Math.pow(10, k + 1);
			s.add(m);
			ls.add(m);
		}
		s.add(x - pre);
		ls.add(x - pre);
		int n =0;
		while (n < s.size()/2) {
			if (s.pop() != ls.poll()) {
				n++;
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(isPalindrome(1234));
		System.out.println(isPalindrome(121));
//		System.out.println(isPalindrome(-121));
//		System.out.println(isPalindrome(10));
	}

}

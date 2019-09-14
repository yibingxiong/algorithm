package leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

public class Code005_LongestPalindrome {

	public static class Com implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return o2 - o1;
		}

	}

	public static String longestPalindrome(String s) {
		if (s.length() == 0) {
			return "";
		}
		HashMap<Character, PriorityQueue<Integer>> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			if (!map.containsKey(c)) {
				map.put(c, new PriorityQueue<>(new Com()));
			}
			map.get(c).add(i);
		}

		int max = 1;
		String res = String.valueOf(s.charAt(0));

		for (int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			PriorityQueue<Integer> cq = map.get(c);
			LinkedList<Integer> list = new LinkedList<>();
			while (!cq.isEmpty()) {
				int k = cq.poll();
				list.add(k);
				if (k > i) {
					String sub = s.substring(i, k+1);
					if (isPalin(sub)) {
						if (k - i + 1 > max) {
							max = k - i + 1;
							res = sub;
						}
						break;
					}
				} else {
					break;
				}
			}
			while (!list.isEmpty()) {
				cq.add(list.poll());
			}
		}
		return res;
	}

	public static boolean isPalin(String s) {
		int len = s.length();
		for (int i = 0; i < len / 2; i++) {
			if (s.charAt(i) != s.charAt(len - i - 1)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalin("adada"));
		System.out.println(longestPalindrome("babadada"));
//		System.out.println(longestPalindrome("babad"));
//		System.out.println(longestPalindrome("cbbd"));
//		System.out.println(longestPalindrome("abcda"));
//		System.out.println(isPalin("abcda"));
	}

}

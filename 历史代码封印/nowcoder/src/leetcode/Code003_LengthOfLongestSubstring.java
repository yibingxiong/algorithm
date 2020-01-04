package leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;


public class Code003_LengthOfLongestSubstring {
	public static class A implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return o1-o2;
		}
		
	}
	public static int lengthOfLongestSubstring(String s) {
		
		char []chars = s.toCharArray();
		int i=0;
		int j=0;
		HashMap<Character, Boolean> map = new HashMap<>();
		int max = 0;
		while(j < chars.length && i <chars.length) {
			if (map.containsKey((Character)chars[j]) && map.get((Character)chars[j])==true) {
				map.put(chars[i++], false);
			} else {
				map.put(chars[j++], true);
				max = Math.max(max, j-i);
			}
		}
		
		return max;
		
	}
	
	public static int process(char[] chars, int i, int j) {
		if (i == j) {
			return 1;
		}
		return process(chars, i, j-1) +  (isIn(chars, i, j-1, j)?0:1);
	}
	
	public static boolean isIn(char []chars, int i, int j, int m) {
		for(int k = i; k <= j; k++) {
			if (chars[k] == chars[m]) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
		System.out.println(lengthOfLongestSubstring("bbbbb"));
		System.out.println(lengthOfLongestSubstring("pwwkew"));
		System.out.println(lengthOfLongestSubstring(" "));
	}

}

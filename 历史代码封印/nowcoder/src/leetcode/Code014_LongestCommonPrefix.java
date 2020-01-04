package leetcode;

import java.util.HashSet;

public class Code014_LongestCommonPrefix {

	public static String longestCommonPrefix(String[] strs) {
		String res = "";
		if (strs.length == 0) {
			return res;
		}
		for (int j = 0; j < strs[0].length(); j ++) {
			char c = '1';
			boolean f = true;
			for (int i = 0; i< strs.length;i++) {
				if (j > strs[i].length()-1) {
					f = false;
					break;
				}
				if (c != '1' && strs[i].charAt(j) !=c) {
					f = false;
					break;
				} else {
					c = strs[i].charAt(j);
				}
			}
			if (f) {
				res = res+c;
			} else {
				return res;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] re = {"aa","a"};
		System.out.println(longestCommonPrefix(re));
	}

}

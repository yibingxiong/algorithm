package leetcode;

import java.util.Stack;

public class Code007_Reverse {

	public static int reverse(int x) {
		int k = Math.abs(x);
		String str = String.valueOf(k);
		String res = "";
		for (int i = str.length()-1; i >= 0; i--) {
			Character c = str.charAt(i);
			if (res != "" || (res == "" && !c.equals('0'))) {
				res += c;
			}
		}
		if (res.length() == 0) {
			res = "0";
		}
		int m=0;
		try {
			m = Integer.valueOf(res);
		} catch (Exception e) {
			m = 0;
		}
		return x < 0 ? -m : m;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse(123));
		System.out.println(reverse(-123));
		System.out.println(reverse(1200));
		System.out.println(reverse(0));
	}

}

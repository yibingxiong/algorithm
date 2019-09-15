package leetcode;

import java.util.Stack;

public class Code066_plusOne {

	public static int[] plusOne(int[] digits) {
		Stack<Integer> stack = new Stack<>();
		int p = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			int k = 0;
			int m = digits[i];
			k = m + p;
			if (k >= 10) {
				int c = k / 10;
				int b = k - c * 10;
				p = c;
				stack.add(b);
			} else {
				stack.add(k);
				p = 0;
			}
		}
		if (p != 0) {
			stack.add(p);
		}
		int [] res = new int[stack.size()];
		
		int i =0;
		while(!stack.isEmpty()) {
			res[i++] = stack.pop();
		}
		return res;
	}

	public static void printArr(int []arr) {
		for(int i =0; i< arr.length; i++) {
			System.out.print(" " + arr[i]);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] k = {9,9,9,9};
		int res [] = plusOne(k);
		printArr(res);
	}

}

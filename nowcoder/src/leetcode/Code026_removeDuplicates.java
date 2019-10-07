package leetcode;

import java.util.Arrays;

public class Code026_removeDuplicates {

	public static int removeDuplicates(int[] nums) {
		if (nums.length < 2) {
			return nums.length;
		}
		int i = 0;
		int j = 1;

		while (j < nums.length) {
			if (nums[i] != nums[j]) {
				int t = nums[++i];
				nums[i] = nums[j];
				nums[j] = t;
			}
			j++;
		}
		return i + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] k = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		System.out.println(removeDuplicates(k));
		System.out.println(Arrays.toString(k));
	}

}

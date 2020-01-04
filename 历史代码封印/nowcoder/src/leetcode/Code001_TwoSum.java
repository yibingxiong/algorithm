
package leetcode;

import java.util.HashMap;

public class Code001_TwoSum {
	public static int[] twoSum(int[] nums, int target) {
		if (nums.length < 2) {
			return null;
		}
		HashMap<Integer, Integer> map = new HashMap<>();

		int[] res = new int[2];
		int mid = target / 2;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > mid) {
				map.put(nums[i], i);
			}
		}

		for (int i = 0; i < nums.length; i++) {
			Integer k = map.get(target - nums[i]);
			if (k != null) {
				res[0] = i;
				res[1] = k;
				return res;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		int[] a = { 1, 3, 4, 2, 5, 8, 7 };
		int t = 9;
		int[] res = twoSum(a, t);
		if (res != null) {
			System.out.print(res[0] + "," + res[1]);
		} else {
			System.out.println("null");
		}
	}
}

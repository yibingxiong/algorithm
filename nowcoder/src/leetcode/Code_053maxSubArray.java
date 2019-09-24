package leetcode;

public class Code_053maxSubArray {

	public static int maxSubArray(int[] nums) {
		int res = nums[0];
		int sum = 0;
		for (int num : nums) {
			if (sum > 0) {
				sum += num;
			}
			else {	
				sum = num;
			}
			res = Math.max(res, sum);
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

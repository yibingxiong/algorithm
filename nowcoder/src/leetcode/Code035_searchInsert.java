package leetcode;

public class Code035_searchInsert {

	public static int searchInsert(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;

		while (start <= end) {
			int mid = start + ((end - start) >> 1);
			int v = nums[mid];
			if (v == target) {
				return mid;
			} else if (target < v) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return start;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 3, 5, 6 };
		int target = 5;
		System.out.println(searchInsert(nums, target));
	}

}

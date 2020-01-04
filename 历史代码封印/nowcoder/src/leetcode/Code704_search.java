package leetcode;

public class Code704_search {

	public static int search(int[] nums, int target) {
		if (nums == null) {
			return -1;
		}
		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}

		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { -1, 0, 3, 5, 9, 12 };
		System.out.println(search(nums, 9));
	}

}

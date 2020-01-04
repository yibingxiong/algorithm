package leetcode;

public class Code017_removeElement {

	public static void swap(int[] nums, int i, int j) {
		int k = nums[i];
		nums[i] = nums[j];
		nums[j] = k;
	}
	public static int removeElement(int[] nums, int val) {
		int i =0;
		int j = 0;
		while( j < nums.length) {
			if (nums[j] != val) {
				swap(nums, i++, j);
			}
			j++;
		}
		return i;
	}

	public static void printArray(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []a = {3,2,2,3};
		System.out.println(removeElement(a, 3));
		printArray(a);
	}

}

package chapter1_test;

import java.util.Arrays;

public class MergeSort {

	public static void mergeSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		process(arr, 0, arr.length-1);
	}
	
	public static void process(int[] arr, int left, int right) {
		if (left == right) {
			return;
		}
		int mid = (right+left)/2;
		process(arr, left, mid);
		process(arr, mid+1, right);
		merge(arr, left, right, mid);
		
	}
	public static void merge(int[] arr, int left, int right, int mid) {
		int[] help = new int[right-left+1];
		int p1 = left;
		int p2 = mid+1;
		int i = 0;
		while(p1 <=mid && p2 <=right) {
			help[i++] = arr[p1] <= arr[p2]?arr[p1++]:arr[p2++];
		}
		while(p1 <= mid) {
			help[i++] = arr[p1++];
		}
		while(p2 <= right) {
			help[i++] = arr[p2++];
		}
		for(int i1 = 0; i1 < help.length; i1++) {
			arr[left+i1] = help[i1];
		}
	}
	
	// for test
		public static void comparator(int[] arr) {
			Arrays.sort(arr);
		}

		// for test
		public static int[] generateRandomArray(int maxSize, int maxValue) {
			int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
			}
			return arr;
		}

		// for test
		public static int[] copyArray(int[] arr) {
			if (arr == null) {
				return null;
			}
			int[] res = new int[arr.length];
			for (int i = 0; i < arr.length; i++) {
				res[i] = arr[i];
			}
			return res;
		}

		// for test
		public static boolean isEqual(int[] arr1, int[] arr2) {
			if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
				return false;
			}
			if (arr1 == null && arr2 == null) {
				return true;
			}
			if (arr1.length != arr2.length) {
				return false;
			}
			for (int i = 0; i < arr1.length; i++) {
				if (arr1[i] != arr2[i]) {
					return false;
				}
			}
			return true;
		}

		// for test
		public static void printArray(int[] arr) {
			if (arr == null) {
				return;
			}
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
	public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 100;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			mergeSort(arr1);
			comparator(arr2);
			if (!isEqual(arr1, arr2)) {
				succeed = false;
				printArray(arr1);
				printArray(arr2);
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");

	}

}

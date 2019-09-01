package chapter1_test;

import java.util.Arrays;

public class QuickSort {

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i]= arr[j];
		arr[j] = tmp;
	}
	public static int partition(int[] arr, int left, int right) {
		int  less = left - 1;
		while(left < right) {
			if (arr[left] < arr[right]) {
				swap(arr, left++, ++less);
			} else {
				left++;
			}
		}
		swap(arr, right, ++less);
		return less;
	}
	
	public static void quickSort(int[] arr, int left, int right) {
		if(left < right) {
			int p = partition(arr, left, right);
			quickSort(arr, left, p-1);
			quickSort(arr, p+1, right);
		}
	}
	public static void quickSort(int[] arr) {
		if (arr == null || arr.length<2) {
			return;
		}
		quickSort(arr, 0, arr.length-1);
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
			quickSort(arr1);
			comparator(arr2);
			if (!isEqual(arr1, arr2)) {
				succeed = false;
				printArray(arr1);
				printArray(arr2);
				break;
			} else {
				System.out.println("正确");
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");

	}

}

package chapter1_test;

import java.util.Arrays;

public class BinarySearch {

	public static boolean binarySearch(int[] arr, int v) {

		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			int mid = (left + right) >> 1;
			if (v == arr[mid]) {
				return true;
			} else if (v > arr[mid]) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return false;
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
	public static boolean search(int[] arr, int v) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == v) {
				return true;
			}
		}
		return false;
	}

	// for test
	public static int getRamdom(int max) {
		return (int) ((max + 1) * Math.random()) - (int) (max * Math.random());
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

	// for test
	public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 100;
		int maxValue = 100;
		int max = 1000;
		boolean success = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr = generateRandomArray(maxSize, maxValue);
			int v = getRamdom(max);
			boolean a1 = search(arr, v);
			Arrays.sort(arr);
			boolean a2 = binarySearch(arr, v);
			if (a1 != a2) {
				success = false;
				printArray(arr);
				System.out.println("怎么回事啊" + v + "锛屾毚鍔涳細" + a1 + ",浜屽垎锛�" + a2);
				return;
			}
		}
		if (success) {
			System.out.println("nice~");
		} else {
			System.out.println("failed!");
		}
	}

}

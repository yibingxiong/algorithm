package chapter1_test;

import java.util.Arrays;

public class Sort {

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	// 冒泡排序
	public static void bubbleSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		for (int i = arr.length - 1; i > 0; i--) {
			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
				}
			}
		}
	}

	// 选择排序
	public static void selectionSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		for (int i = 0; i < arr.length - 1; i++) {
			int minV = arr[i];
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < minV) {
					minV = arr[j];
					minIndex = j;
				}
			}
			swap(arr, i, minIndex);
		}
	}

	// 插入排序
	public static void inserSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		for (int i = 1; i < arr.length; i++) {
			int j = i;
			while (j > 0 && arr[j] < arr[j - 1]) {
				swap(arr, j, --j);
			}
		}
	}

	// 归并排序
	public static void mergeSort(int[] arr, int left, int right) {
		if (left == right) {
			return;
		}
		int mid = left + ((right - left) / 2);
		mergeSort(arr, left, mid);
		mergeSort(arr, mid + 1, right);
		merge(arr, left, right, mid);
	}

	public static void mergeSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		mergeSort(arr, 0, arr.length - 1);
	}

	public static void merge(int[] arr, int left, int right, int mid) {
		int[] help = new int[right - left + 1];
		int p1 = left;
		int p2 = mid + 1;
		int i = 0;
		while (p1 <= mid && p2 <= right) {
			help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
		}
		while (p1 <= mid) {
			help[i++] = arr[p1++];
		}
		while (p2 <= right) {
			help[i++] = arr[p2++];
		}

		for (int k = 0; k < help.length; k++) {
			arr[left + k] = help[k];
		}
	}

	// 堆排序
	public static void heapSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			heapInsert(arr, i);
		}

		for (int i = 0; i < arr.length; i++) {
			swap(arr, 0, arr.length - i - 1);
			heapyify(arr, 0, arr.length - i - 1);
		}
	}

	public static void heapInsert(int[] arr, int i) {
		while (arr[i] > arr[(i - 1) / 2]) {
			swap(arr, i, (i - 1) / 2);
			i = (i - 1) / 2;
		}
	}

	public static void heapyify(int[] arr, int i, int heapSize) {
		int left = 2 * i + 1; // 左孩子
		while (left < heapSize) {
			int larges = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
			larges = arr[i] > arr[larges] ? i : larges;
			if (larges == i) { // 当前节点比两个孩子都大
				break;
			}
			swap(arr, i, larges);
			i = larges;
			left = 2 * i + 1;
		}
	}
	
	// 快速排序
	public static void quickSort(int[] arr) {
		if(arr == null || arr.length < 2) {
			return;
		}
		quickSort(arr, 0, arr.length-1);
	}
	public static void quickSort(int[] arr, int left, int right) {
		if (left < right) {
			swap(arr, left + (int) (Math.random() * (right - left + 1)), right);
			int p = partiton(arr, left, right);
			quickSort(arr, left, p-1);
			quickSort(arr, p+1, right);
		}
	}
	
	public static int partiton(int[] arr, int left, int right) {
		int less = left-1;
		while(left < right) {
			if(arr[left] < arr[right]) {
				swap(arr, ++less, left++);
			} else {
				left++;
			}
		}
		swap(arr, ++less, right);
		return less;
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
	
	// for test
	public static void printArray(long[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// for test
	public static boolean sortTest(int[] arrRight, int[] arrYours, String str) {
		if (!isEqual(arrRight, arrYours)) {
			printArray(arrYours);
			printArray(arrRight);
			System.out.println(str + "结果不对");
			return false;
		}
		return true;
	}
	public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 100;
		int maxValue = 100;
		boolean succeed = true;
		long[] time = new long[6];
		for (int i = 0; i < testTime; i++) {
			int[] initArr = generateRandomArray(maxSize, maxValue);
			int[] arrRight = copyArray(initArr);
			int[] bubbleArr = copyArray(initArr);
			int[] selectionArr = copyArray(initArr);
			int[] insertArr = copyArray(initArr);
			int[] mergeArr = copyArray(initArr);
			int[] heapArr = copyArray(initArr);
			int[] quickArr = copyArray(initArr);
			long bubbleStart,selectionStart,insertStart, mergeStart,quickStart, heapStart;
			
			bubbleStart = System.currentTimeMillis();
			bubbleSort(bubbleArr);
			time[0] = time[0] + System.currentTimeMillis() - bubbleStart;
			
			selectionStart = System.currentTimeMillis();
			selectionSort(selectionArr);
			time[1] = time[1] + System.currentTimeMillis() - selectionStart;
			
			insertStart = System.currentTimeMillis();
			inserSort(insertArr);
			time[2] = time[2] + System.currentTimeMillis() - insertStart;
			
			mergeStart = System.currentTimeMillis();
			mergeSort(mergeArr);
			time[3] = time[3] + System.currentTimeMillis() - mergeStart;
			
			heapStart = System.currentTimeMillis();
			heapSort(heapArr);
			time[4] = time[4] + System.currentTimeMillis() - heapStart;
			
			quickStart = System.currentTimeMillis();
			quickSort(quickArr);
			time[5] = time[5] + System.currentTimeMillis() - quickStart;
			
			comparator(arrRight);
			if (!sortTest(arrRight, bubbleArr, "冒泡排序")) {
				break;
			}
			if (!sortTest(arrRight, selectionArr, "选择排序")) {
				break;
			}
			if (!sortTest(arrRight, insertArr, "插入排序")) {
				break;
			}
			if (!sortTest(arrRight, mergeArr, "归并排序")) {
				break;
			}
			if (!sortTest(arrRight, heapArr, "堆排序")) {
				break;
			}
			if (!sortTest(arrRight, quickArr, "快速排序")) {
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");
		printArray(time);;

	}

}

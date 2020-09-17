package com.xiong.learn.nowcoder.ch1;

import java.util.Arrays;

public class SortTest {


    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void selectSort(int[] arr) {
        if (arr == null) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    public static void bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j + 1] < arr[j]) {
                    swap(arr, j + 1, j);
                }
            }
        }
    }

    public static void insertSort(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 1; i < arr.length - 1; i++) {
            int j = i + 1;
            while (j - 1 >= 0 && arr[j] < arr[j - 1]) {
                swap(arr, j, j - 1);
                j--;
            }
        }
    }

    public static int bSearch(int[] arr, int k) {
        int i = 0;
        int j = arr.length - 1;

        while (j >= i) {
            int mid = i + (j - i) / 2;
            if (arr[mid] == k) {
                return mid;
            } else if (arr[mid] > k) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }

        return -1;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int[] arrcopy(int[] arr) {
        int[] ints = Arrays.copyOf(arr, arr.length);
        return ints;
    }

    /**
     * >=k的最左侧位置
     *
     * @param arr
     * @param k
     * @return
     */
    public static int findFirstLessOrEqual(int[] arr, int k) {
        int i = 0;
        int j = arr.length - 1;
        int last = -1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (arr[mid] < k) {
                i = mid + 1;
            } else {
                last = mid;
                j = mid - 1;
            }
        }
        return last;
    }

    public static void mergeSort(int[] arr, int i, int j) {
        if (i < j) {
            int mid = i + (j - i) / 2;
            mergeSort(arr, i, mid);
            mergeSort(arr, mid + 1, j);
            merge(arr, i, j, mid);
        }
    }

    private static void merge(int[] arr, int i, int j, int mid) {
        int[] tmp = new int[j - i + 1];
        int k = 0;
        int p = i;
        int q = mid+1;
        while (p <= mid && q <= j) {
            if (arr[p] <= arr[q]) {
                tmp[k++] = arr[p++];
            } else {
                tmp[k++] = arr[q++];
            }
        }
        while (p <= mid) {
            tmp[k++] = arr[p++];
        }
        while (q <= j) {
            tmp[k++] = arr[q++];
        }

        k = 0;

        while (k < j - i + 1) {
            arr[i + k] = tmp[k++];
        }
    }

    public static void main(String[] args) {
        int[] k = {0, 6, 1, 12, 5, 7, 2, 2, 2, 2};
        int[] arr1 = arrcopy(k);
        selectSort(arr1);
        print(arr1);
        System.out.println("\n---------bubbble");
        int[] arr2 = arrcopy(k);
        bubbleSort(arr2);
        print(arr2);
        System.out.println("\n---------insert");
        int[] arr3 = arrcopy(k);
        insertSort(arr3);
        print(arr3);
        System.out.println("\n-------二分查找");
        System.out.println(bSearch(arr3, 12));
        System.out.println("\n-------找第一个小于等于某个数的位置");
        System.out.println(findFirstLessOrEqual(arr3, 2));

        System.out.println("\n---------merge sort");
        int[] arr4 = arrcopy(k);
        mergeSort(arr4, 0 , arr4.length-1);
        print(arr4);
    }
}

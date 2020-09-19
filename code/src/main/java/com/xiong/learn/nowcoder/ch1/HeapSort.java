package com.xiong.learn.nowcoder.ch1;

public class HeapSort {

    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void heapInsert(int[] arr, int i) {
        while ((i - 1) / 2 >= 0 && arr[i] > arr[(i - 1) / 2]) {
            swap(arr, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    public static void heapify(int[] arr, int i, int size) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        while (l < size) {
            int largestIndex = r < size && arr[r] > arr[l] ? r : l;
            if (arr[i] < arr[largestIndex]) {
                swap(arr, i, largestIndex);
                i = largestIndex;
                l = 2 * i + 1;
                r = 2 * i + 2;
            } else {
                break;
            }
        }
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }


    public static void heapSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int size = arr.length;
        while (size > 0) {
            swap(arr, 0, size - 1);
            heapify(arr, 0, --size);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 6, 5};
        heapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}

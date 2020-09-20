package com.xiong.learn.nowcoder.ch2;

public class QuickSort {
    public static void quickSort(int[] arr, int i, int j) {
        if (i < j) {
            int[] pos = partition(arr, i, j);
            quickSort(arr, i, pos[0]);
            quickSort(arr, pos[1], j);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static int[] partition(int[] arr, int i, int j) {
        // 防止出现坏情况, 已经是有序的数组
        swap(arr, i + (int) Math.random() * ((j - i) + 1), j);
        int left = i - 1;
        int right = j;
        int p = i;
        int target = arr[j];
        while (p < right) {
            if (arr[p] > target) {
                swap(arr, --right, p);
            } else if (arr[p] < target) {
                swap(arr, p++, ++left);
            } else {
                p++;
            }
        }
        swap(arr, right, j);

        return new int[]{left, right};
    }


    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {6, 1, 3, 65, 5, 9, 10};
        quickSort(arr, 0, arr.length - 1);
        print(arr);
    }
}

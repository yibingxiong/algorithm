package com.xiong.fenzhi;

public class MergeSort {
    public static void merge(int[] a, int left, int mid, int right) {
        int[] tmp = new int[a.length];//辅助数组
        int p1 = left, p2 = mid + 1, k = left;//p1、p2是检测指针，k是存放指针

        while (p1 <= mid && p2 <= right) {
            if (a[p1] <= a[p2])
                tmp[k++] = a[p1++];
            else
                tmp[k++] = a[p2++];
        }

        while (p1 <= mid) tmp[k++] = a[p1++];//如果第一个序列未检测完，直接将后面所有元素加到合并的序列中
        while (p2 <= right) tmp[k++] = a[p2++];//同上

        //复制回原素组
        for (int i = left; i <= right; i++)
            a[i] = tmp[i];
    }

    public static void mergeSort(int[] a, int start, int end) {
        if (start < end) {//当子序列中只有一个元素时结束递归
            int mid = start + (end - start) / 2;//划分子序列
            mergeSort(a, start, mid);//对左侧子序列进行递归排序
            mergeSort(a, mid + 1, end);//对右侧子序列进行递归排序
            merge(a, start, mid, end);//合并
        }
    }


    // 默写一遍归并排序

    public static void mergeSort2(int[] arr, int m, int n) {
        if (m < n) {
            int mid = m + (n - m) / 2;
            mergeSort2(arr, m, mid);
            mergeSort2(arr, mid + 1, n);
            merge2(arr, m, n, mid);
        }
    }

    public static void merge2(int[] arr, int i, int j, int mid) {
        int[] tmp = new int[j - i + 1]; // 辅助数组

        int p = i;  // 左边数组访问到的位置
        int q = mid + 1; // 右边数组访问的位置

        int k = 0;
        while (p <= mid && q <= j) {
            if (arr[p] < arr[q]) {
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
        for (k = i; k <= j; k++) {
            arr[k] = tmp[k - i];
        }
    }


    public static void mergeSort3(int[] arr, int i, int j) {
        if (i < j) {
            int mid = i + (j - i) / 2;
            mergeSort3(arr, i, mid);
            mergeSort3(arr, mid + 1, j);
            merge3(arr, i, j, mid);
        }
    }

    public static void merge3(int[] arr, int i, int j, int mid) {
        int[] tmp = new int[j - i + 1];
        int p = i;
        int q = mid + 1;
        int k = 0;
        while (p <= mid && q <= j) {
            if (arr[p] < arr[q]) {
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

        for (k = i; k <= j; k++) {
            arr[k] = tmp[k - i];
        }
    }

    public static void main(String[] args) {
        int arr[] = {3, 6, 3, 5, 1, 2, 3, 5, 7};

        int arr2[] = {3, 6, 3, 5, 1, 2, 3, 5, 7};
        int arr3[] = {3, 6, 3, 5, 1, 2, 3, 5, 7};
        mergeSort(arr, 0, arr.length - 1);
        mergeSort2(arr2, 0, arr2.length - 1);
        mergeSort3(arr3, 0, arr3.length-1);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + ", ");
        }
        System.out.println();
        for (int i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i] + ", ");
        }
    }
}

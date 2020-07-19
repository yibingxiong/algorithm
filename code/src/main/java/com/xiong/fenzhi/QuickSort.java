package com.xiong.fenzhi;

/**
 * 快速排序
 */
public class QuickSort {
    public static void swap(int[] arr, int i, int j) {
        int m = arr[i];
        arr[i] = arr[j];
        arr[j] = m;
    }

    public static void sort(int[] arr, int i, int j) {
        if (i < j) {
            int pos = partition(arr, i, j);
            sort(arr, i, pos - 1);
            sort(arr, pos + 1, j);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];//先定义区间数组第一个元素为主元
        int i = left;   //定义最低的索引low是first+1。比主元大一位
        int j = right;     //定义最高的索引high是last
        while (i < j) {   //当low小于high的位置时，执行以下循环
            while (arr[j] > pivot && i < j) {//当high的索引上的值比主元大时，且索引大于low时
                j--;                      //寻找比主元小的值的位置索引
            }
            while (arr[i] <= pivot && i < j) {//当low的索引上的值比主元小时，索引小于high时
                i++;                       //寻找比主元大的值的位置索引。
            }
            swap(arr, i, j);
        }

        arr[left] = arr[j];
        arr[j] = pivot;
        return j;
    }

    public static void sort2(int[] arr, int i, int j) {
        if (i < j) {
            int p = partition2(arr, i, j);
            sort2(arr, i, p - 1);
            sort2(arr, p + 1, j);
        }
    }

    public static int partition2(int[] arr, int low, int high) {
        int x = arr[low];
        int i = low;
        int j = high;
        while (i < j) {
            while (i < j && arr[j] > x) {
                j--;
            }
            while (i < j && arr[i] <= x) {
                i++;
            }

            swap(arr, i, j);
        }
        arr[low] = arr[j];
        arr[j] = x;
        return j;
    }


    public static void main(String[] args) {
        int arr2[] = {1, 6, 5, 5, 4, 2, 3, 5, 7};

        sort2(arr2, 0, arr2.length - 1);
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + ", ");
        }
    }
}
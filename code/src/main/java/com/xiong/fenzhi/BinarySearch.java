package com.xiong.fenzhi;

public class BinarySearch {
    public static int search(int[] arr, int m, int n, int k) {
        if (m <= n) {
            int mid = (m + n) / 2;
            if (arr[mid] == k) {
                return mid;
            } else if (k < arr[mid]) {
                return search(arr, m, mid - 1, k);
            } else {
                return search(arr, mid + 1, n, k);
            }
        } else {
            return -1;
        }
    }

    public static int search2(int[] arr, int k) {
        int m = 0;
        int n = arr.length - 1;
        while (m <= n) {
            int mid = (n + m) / 2;
            if (arr[mid] == k) {
                return mid;
            } else if (arr[mid] < k) {
                m = mid + 1;
            } else {
                n = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6, 8, 9, 10};
        int[] arr2 = {1};
//        System.out.println(search(arr, 0, arr.length - 1, 6));
//        System.out.println(search(arr, 0, arr.length - 1, 11));
//        System.out.println(search(arr, 0, arr.length - 1, 7));
//        System.out.println(search(arr, 0, arr.length - 1, 1));
//        System.out.println(search(arr, 0, arr.length - 1, 10));
        System.out.println(search2(arr2, 1));

    }
}

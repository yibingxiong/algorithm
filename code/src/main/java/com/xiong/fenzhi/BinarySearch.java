package com.xiong.fenzhi;

public class BinarySearch {
    public static int search(int[] arr, int m, int n, int k) {
        if (arr.length == 1) {
            if (arr[0] == k) {
                return 0;
            } else {
                return -1;
            }
        }


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

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6, 8, 9, 10};

        System.out.println(search(arr, 0, arr.length - 1, 6));
        System.out.println(search(arr, 0, arr.length - 1, 11));
        System.out.println(search(arr, 0, arr.length - 1, 7));
        System.out.println(search(arr, 0, arr.length - 1, 1));
        System.out.println(search(arr, 0, arr.length - 1, 10));

    }
}

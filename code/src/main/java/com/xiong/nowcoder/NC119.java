package com.xiong.nowcoder;

import java.util.ArrayList;

/**
 * 时间复杂度， 最坏的就是数组是倒序的，要找到 k==数组长度，复杂度为O(n^2)
 */
public class NC119 {
    public static class Solution {
        public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
            Integer[] arr = new Integer[k];
            int size = 0;
            for (int i = 0; i < input.length; i++) {
                if (size < k) {
                    insert(arr, size++, input[i]);
                } else {
                    if (input[i] < arr[k - 1]) {
                        insert(arr, k - 1, input[i]);
                    }
                }
            }
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != null) {
                    list.add(arr[i]);
                }
            }
            return list;
        }

        private void swap(Integer[] a, int p, int j) {
            int t = a[p];
            a[p] = a[j];
            a[j] = t;
        }

        private void insert(Integer[] a, int p, int m) {
            int t = p;
            a[p] = m;
            while (t > 0 && a[t] < a[t - 1]) {
                swap(a, t, t - 1);
                t--;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.GetLeastNumbers_Solution(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 10));
    }
}

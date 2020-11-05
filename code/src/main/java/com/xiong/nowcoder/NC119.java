package com.xiong.nowcoder;

import java.util.ArrayList;

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
                list.add(arr[i]);
            }
            return list;
        }

        private void insert(Integer[] a, int p, int m) {
            int t = p;
            a[p] = m;
            while (m <= a[t] && t > 0) {
                a[t] = a[t - 1];
                t--;
            }
            a[t] = m;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.GetLeastNumbers_Solution(new int[]{1,3,4,0}, 3));
    }
}

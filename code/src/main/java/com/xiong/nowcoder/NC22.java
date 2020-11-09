package com.xiong.nowcoder;

public class NC22 {
    public class Solution {
        // 这种解法空间复杂度太高了
        public void merge(int A[], int m, int B[], int n) {
            int[] tmp = new int[A.length];
            int i = 0;
            int j = 0;
            int k = 0;
            while (i < m && j < n) {
                if (A[i] < B[j]) {
                    tmp[k++] = A[i++];
                } else {
                    tmp[k++] = B[j++];
                }
            }
            while (i < m) {
                tmp[k++] = A[i++];
            }
            while (j < n) {
                tmp[k++] = B[j++];
            }
            for (int p = 0; p < tmp.length; p++) {
                A[p] = tmp[p];
            }
        }
    }
}

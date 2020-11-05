package com.xiong.nowcoder;

/**
 * TODO: 分析复杂度 && 尝试用堆解决
 */
public class NC88 {
    public static class Finder {
        public int findKth(int[] a, int n, int K) {
            // write code here
            return findKth(a, 0, n - 1, K);
        }

        private int findKth(int[] a, int i, int j, int K) {
            int p = partition(a, i, j);
            int t = p - i + 1; // i 到 p 有几个数
            if (K < t) {
                return findKth(a, i, p - 1, K);
            } else if (K == t) {
                return a[p];
            } else {
                return findKth(a, p + 1, j, K - t);
            }
        }

        private void swap(int[] a, int i, int j) {
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
        }

        private int partition(int[] a, int i, int j) {
            int l = i;
            int x = a[i];
            int p = i + 1;
            while (p <= j) {
                if (a[p] >= x) {
                    p++;
                    i++;
                } else {
                    swap(a, p, j--);
                }
            }
            swap(a, l, i);
            return i;
        }
    }

    public static void main(String[] args) {
        Finder finder = new Finder();
        int kth = finder.findKth(new int[]{8,7,6,5,4,3,2,1}, 8, 2);
        System.out.println(kth);
    }
}

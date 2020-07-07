package com.xiong.digui;

public class Perm {
    public static void swap(Object[] list, int i, int j) {
        Object tmp = list[i];
        list[i] = list[j];
        list[j] = tmp;
    }

    public static void perm(Object[] list, int k, int m) {
        if (k == m) {
            for (int i = 0; i <= m; i++) {
                System.out.print(list[i]);
            }
            System.out.println();
        } else {
            for (int i = k; i <= m; i++) {
                swap(list, i, k);
                perm(list, k + 1, m);
                swap(list, i, k);
            }
        }
    }

    public static void main(String[] args) {
        String a[] = {"a", "b", "c"};
        perm(a, 0, a.length - 1);
    }
}

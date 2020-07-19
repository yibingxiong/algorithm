package com.xiong.fenzhi;

public class SortUtils {
    public static int[] copy(int[] arr) {
        int[] t = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            t[i] = arr[i];
        }
        return t;
    }

    public static boolean compare(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1 == null && arr2 != null) {
            return false;
        }
        if (arr2 == null && arr1 != null) {
            return false;
        }

        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static int[] generateArr(int k) {
        int[] res = new int[k];

        for (int i = 0; i < res.length; i++) {
            res[i] = (int) (Math.random() * 100);
        }
        return res;
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
    }

    public static void main(String[] args) {
        int caseNum = 1000;

        for (int i = 0; i < caseNum; i++) {
            int[] c = generateArr((int) (Math.random() * 10000));
            int[] cp1 = copy(c);
            int[] cp2 = copy(c);
            long start = System.currentTimeMillis();
            QuickSort.sort2(cp1, 0, cp1.length - 1);
            System.out.println("排序1耗時:" + (System.currentTimeMillis() - start));
            start = System.currentTimeMillis();
            MergeSort.mereSort6(cp2, 0, cp2.length - 1);
            System.out.println("排序2耗時:" + (System.currentTimeMillis() - start));
            boolean pass = compare(cp1, cp2);
            if (pass) {
                System.out.println("pass");
            } else {
                System.out.println("原始:");
                printArr(c);
                System.out.println();
                printArr(cp1);
                System.out.println();
                printArr(cp2);
                throw new RuntimeException("出錯了");
            }
        }
    }
}

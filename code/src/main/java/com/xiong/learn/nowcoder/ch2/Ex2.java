package com.xiong.learn.nowcoder.ch2;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Ex2 {
    public static class Main {
        private static boolean isZimu(char c) {
            if ((c >= 'a' && c <= 'z') || c >= 'A' && c <= 'Z') {
                return true;
            }
            return false;
        }


        private static void mergeSort(char[] arr, int i, int j) {
            if (i < j) {
                int mid = i + (j - i) / 2;
                mergeSort(arr, i, mid);
                mergeSort(arr, mid + 1, j);
                merge(arr, i, j, mid);
            }
        }

        private static void merge(char[] arr, int i, int j, int mid) {
            char[] tmp = new char[j - i + 1];
            int p  = i;
            int q = mid+1;
            int k = 0;
            Queue<Character> queue = new LinkedList<>();
            while (p <= mid && q <= j) {
                if (!isZimu(arr[p])) {
                    tmp[k++] = arr[p];
                } else if (!isZimu(arr[q])) {
                    queue.add(arr[q]);
                }
            }
        }


        public static void main(String[] args) throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String s;
            while ((s = in.readLine()) != null) {
                char[] arr = s.toCharArray();
                int len = arr.length;
                mergeSort(arr, 0, len - 1);
                System.out.println(new String(arr));
            }
        }
    }
}

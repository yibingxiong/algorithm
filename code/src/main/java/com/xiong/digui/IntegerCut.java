package com.xiong.digui;

/**
 * 整数划分问题
 * contCut(n,m)表示用小于等于m的数去划分n，有多少中情况
 */
public class IntegerCut {
    public static int contCut(int n, int m) {
        if (n == 1 || m == 1) {
            return 1;
        }
        if (n == m) {
            return 1 + contCut(n, m - 1);
        }
        if (n < m) {
            return contCut(n, n);
        }
        return contCut(n - m, m) + contCut(n, m - 1);
    }

    public static void main(String[] args) {
        System.out.println(contCut(6, 6));
    }
}

package com.xiong.digui;

/**
 * 汉诺塔问题
 */
public class hanno {
    public static void ha(int n, String a, String b, String c) {
        if (n == 1) {
            System.out.println(a+"->"+b);
        } else if (n > 0) {
            ha(n-1, a,c,b);
            System.out.println(a+"->"+b);
            ha(n-1, c, b,a);
        }
    }
    public static void main(String[] args) {
        ha(3, "A","B","C");
    }
}

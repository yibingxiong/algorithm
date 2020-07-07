package com.xiong.digui;

/**
 * 描述：一个简单的采用递归方法求阶乘的例子
 */
public class Jiechen {
    public static int jiecheng(int n) {
        if (n == 1) {
            return 1;
        }
        return n * jiecheng(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(jiecheng(5));
    }
}

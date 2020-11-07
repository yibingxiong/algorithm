package com.xiong.nowcoder;

/**
 * 非常重要的点
 * 1. 异或运算的特点
 * 2. 提取一个数最右侧的1的技巧
 */
public class NC75 {
    public class Solution {
        public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
            int aor = 0;
            for (int i = 0; i < array.length; i++) {
                aor = aor ^ array[i];
            }
            int right1 = aor & (~aor + 1);
            int a = 0;
            for (int i = 0; i < array.length; i++) {
                if ((array[i] & right1) != 0) {
                    a = a ^ array[i];
                }
            }
            int b = a ^ aor;
            num1[0] = a;
            num2[0] = b;
        }
    }
}

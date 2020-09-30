package com.xiong.learn.nowcoder.ch8;

import java.util.HashSet;

public class AllRank {
    public static void printAllRank(String str) {
        char[] chars = str.toCharArray();
        process(chars, 0, chars.length - 1);
    }

    public static void swap(char[] chars, int i, int j) {
        char a = chars[i];
        chars[i] = chars[j];
        chars[j] = a;
    }

    public static void process(char[] chars, int i, int j) {
        if (i == j) {
            System.out.println(String.valueOf(chars));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int k = i; k <= j; k++) {
            if (!set.contains(chars[k])) {
                set.add(chars[k]);
                swap(chars, i, k);
                process(chars, i + 1, j);
                swap(chars, i, k);
            }
        }
    }


    public static void main(String[] args) {
        String a = "ABBC";
        printAllRank(a);
    }

}

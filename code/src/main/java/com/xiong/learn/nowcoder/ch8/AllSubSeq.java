package com.xiong.learn.nowcoder.ch8;

public class AllSubSeq {

    public static void allSub(String str) {
        process(str, 0, "");
    }

    public static void process(String str, int index, String s) {
        if (index == str.length()) {
            System.out.println(s);
            return;
        }
        process(str, index + 1, s + str.charAt(index));
        process(str, index + 1, s);
    }

    public static void allSub2(String str) {
        char[] chars = str.toCharArray();
        process2(chars, 0);
    }

    public static void process2(char[] chars, int i) {
        if (i == chars.length) {
            System.out.println(String.valueOf(chars));
            return;
        }
        char t = chars[i];
        process2(chars, i + 1);
        chars[i] = 0;
        process2(chars, i + 1);
        chars[i] = t;
    }

    public static void main(String[] args) {
        String str = "ABC";
        allSub(str);
        System.out.println("---------");
        allSub2(str);
        System.out.println("-----------");
        char a = 0;
        System.out.println(a);
    }
}

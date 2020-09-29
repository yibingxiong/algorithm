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
        process(str, index+1, s+str.charAt(index));
        process(str, index+1, s);
    }
    public static void main(String[] args) {
        String str = "ABC";
        allSub(str);
    }
}

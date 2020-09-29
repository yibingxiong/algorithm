package com.xiong.learn.nowcoder.ch8;

public class Hannuota {


    public static void process(int i, String A, String B, String C) {
        if (i == 0) {
            System.out.println(i + " from " + A + " to " + B);
            return;
        }
        process(i-1, A, C,B);
        System.out.println(i + " from " + A + " to " + B);
        process(i-1, C, B, A);
    }
    public static void main(String[] args) {
        process(2, "A","B","C");
    }
}

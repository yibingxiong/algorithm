package com.xiong.test;

import java.util.ArrayList;

/**
 * Created by daxiong on 2020/11/21 11:13
 */
public class A {
    private static final String a = "a";
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        for (Integer integer : arrayList) {
            System.out.println(integer);
        }
        for (Integer integer : arrayList) {

        }
        /*for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            System.out.println(arg);
        }*/

        if (arrayList == null) {

            System.out.println(3);

        }
        for (Integer integer : arrayList) {

        }
    }
}

package com.xiong.tanxin;

import java.util.*;

public class Load {

    static class E {
        private int i;
        private int v;

        public E(int i, int v) {
            this.i = i;
            this.v = v;
        }
    }

    public static void cal1(int[] w, int c) {
        E[] eList = new E[w.length];
        for (int i = 0; i < w.length; i++) {
            eList[i] = new E(i, w[i]);
        }
        Arrays.sort(eList, new Comparator<E>() {
            public int compare(E o1, E o2) {
                return o1.v - o2.v;
            }
        });

        List<E> list = new ArrayList<E>();

        for (int i = 0; i < eList.length && c > 0; i++) {
            if (eList[i].v <= c) {
                list.add(eList[i]);
                c = c - eList[i].v;
            } else {
                break;
            }
        }

        Iterator<E> iterator = list.iterator();
        while (iterator.hasNext()) {
            E a = iterator.next();
            System.out.println("选择第"+(a.i+1) + "个");
        }
    }
    public static void main(String[] args) {
        int[] a = {1,19,18,3,1};
        int c = 20;

        cal1(a, c);
    }
}

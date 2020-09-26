package com.xiong.learn.nowcoder.ch7;

import java.util.*;

public class StrConcat {
    public static String concat(String[] strs) {
        if (strs == null || strs.length == 0) {
            return null;
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });

        String res = "";
        for (int i = 0; i < strs.length; i++) {
            res += strs[i];

        }
        return res;
    }

    public static String concat2(String[] strs) {
        ArrayList<String> list = new ArrayList<>();
        doConcat(strs, 0, list);
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        return list.get(0);
    }

    public static void doConcat(String[] strings, int start, List<String> list) {
        if (start == strings.length - 1) {
            String a = "";
            for (int i = 0; i < strings.length; i++) {
                a += strings[i];
            }
            list.add(a);
        } else {
            for (int i = start; i <= strings.length - 1; i++) {
                //把第一个元素分别与后面的元素进行交换，递归的调用其子数组进行排序
                Swap(strings, i, start);
                doConcat(strings, start + 1, list);
                Swap(strings, i, start);
                //子数组排序返回后要将第一个元素交换回来。
                //如果不交换回来会出错，比如说第一次1、2交换，第一个位置为2，子数组排序返回后如果不将1、2
                //交换回来第二次交换的时候就会将2、3交换，因此必须将1、2交换使1还是在第一个位置
            }
        }
    }

    private static void Swap(String[] strings, int i, int start) {
        String a = strings[i];
        strings[i] = strings[start];
        strings[start] = a;
    }

    public static void main(String[] args) {
        String[] a = {"bd", "ba"};
        System.out.println(concat(a));
        System.out.println(concat2(a));
    }
}

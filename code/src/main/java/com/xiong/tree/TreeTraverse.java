package com.xiong.tree;

import java.io.File;

public class TreeTraverse {
    public static void printName(String name ,int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print(" ");
        }
        System.out.println(name);
    }
    public static void traverse(File file, int depth) {
        printName(file.getName(), depth);
        System.out.println(depth);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                traverse(files[i], ++depth);
            }
        }
    }
    public static void main(String[] args) {
        File file = new File("D:\\github\\my\\algorithm\\code\\src");
        traverse(file, 0);

    }
}

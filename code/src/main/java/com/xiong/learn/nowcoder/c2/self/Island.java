package com.xiong.learn.nowcoder.c2.self;

public class Island {
    public static int getIslandNum(int[][] m) {
        int r = m.length;
        int c = m[0].length;
        int res = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (m[i][j] == 1) {
                    res++;
                    infect(m, i, j, r, c);
                }
            }
        }
        return res;
    }

    private static void infect(int[][] m, int i, int j, int r, int c) {
        if (i < 0 || i >= r || j < 0 || j >= c || m[i][j] != 1) {
            return;
        }
        m[i][j] = 2;
        infect(m, i - 1, j, r, c);
        infect(m, i + 1, j, r, c);
        infect(m, i, j-1, r, c);
        infect(m, i , j+1, r, c);
    }

    public static void main(String[] args) {
        int[][] m1 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 0, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 1, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
        System.out.println(getIslandNum(m1));

        int[][] m2 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 1, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 1, 0, 0, 0, 1, 1, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
        System.out.println(getIslandNum(m2));
    }
}

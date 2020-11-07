package com.xiong.nowcoder;

/**
 * TODO: 采用并查集解决此问题
 */
public class NC109 {
    // 这种接法有栈溢出问题，需要用并查集解决，感觉并查集还没搞通，暂缓
    public class Solution {
        /**
         * 判断岛屿数量
         * @param grid char字符型二维数组
         * @return int整型
         */
        public int solve (char[][] grid) {
            // write code here
            if (grid == null) {
                return 0;
            }
            int r = grid.length;
            if (r==0) {
                return 0;
            }
            int res= 0;
            int c = grid[0].length;
            for(int i =0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (grid[i][j] == '1') {
                        res++;
                        infect(grid, i, j, r, c);
                    }
                }
            }
            return res;
        }
        private void infect(char[][] grid, int i, int j, int r, int c) {
            if (i<0 || i >= r || j < 0 || j >= c || grid[i][j] !='1') {
                return;
            }
            grid[i][j] = 2;
            infect(grid,i-1,j,r,c);
            infect(grid,i,j-1,r,c);
            infect(grid,i+1,j,r,c);
            infect(grid,i,j+1,r,c);
        }
    }
}

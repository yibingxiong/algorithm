package com.xiong.nowcoder;

public class NC29 {
    public class Solution {
        /**
         * 感觉是比较简单的， 首先用第一列二分，看目标值可能在哪一行，
         *  然后在目标行二分... 傻了， 直接一行一行看不就完了，比较最后一个数第一个数，判断在哪一行
         * @param matrix int整型二维数组
         * @param target int整型
         * @return bool布尔型
         */
        public boolean searchMatrix (int[][] matrix, int target) {
            // write code here
            if (matrix == null) {
                return false;
            }
            int row = matrix.length;
            if (row < 1) {
                return false;
            }
            int col = matrix[0].length;
            int nowRow = 0;
            int targetRow = 0;
            while (nowRow < row) {
                if (matrix[nowRow][0] == target) {
                    return true;
                } else if (matrix[nowRow][0] > target) {
                    return false;
                } else {
                    if (matrix[nowRow][col-1] ==target) {
                        return true;
                    } else if (matrix[nowRow][col-1] > target) {
                        targetRow = nowRow;
                        break;
                    } else {
                        nowRow++;
                    }
                }
            }
            int start =0;
            int end = col-1;
            while(start <= end) {
                int mid = start + (end - start)/2;
                if (matrix[targetRow][mid] == target) {
                    return true;
                } else if (matrix[targetRow][mid] >  target) {
                    start = mid+1;
                } else {
                    end = mid-1;
                }
            }


            return false;
        }
    }
}

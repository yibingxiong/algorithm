package leetcode;

// https://leetcode-cn.com/problems/largest-rectangle-in-histogram/


import com.sun.javaws.exceptions.ErrorCodeResponseException;

public class Code00084 {

    // n^2的暴力解法
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            int minHeight = Integer.MAX_VALUE;
            for (int j = i; j < heights.length; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                res = Math.max(res, (j - i + 1) * minHeight);
            }
        }
        return res;
    }

    // 分治算法
    public int largestRectangleArea2(int[] heights) {
        if (heights == null) {
            throw new IllegalArgumentException();
        }
        if (heights.length == 0) {
            return 0;
        }
        if (heights.length == 1) {
            return heights[0];
        }
        return cal(heights, 0, heights.length - 1);
    }

    private int cal(int[] heights, int i, int j) {
        if(  j < i) {
            return 0;
        }

        int minIndex = i;
        for (int k = i + 1; k <= j; k++) {
            if (heights[minIndex] > heights[k]) {
                minIndex = k;
            }
        }

        int leftMaxArea = cal(heights, i, minIndex - 1);
        int rightMaxArea = cal(heights, minIndex + 1, j);


        return Math.max(Math.max(leftMaxArea, rightMaxArea), (j - i + 1) * heights[minIndex]);
    }

    public static void main(String[] args) {
        int[] k = {2,1,5,6,2,3};
        int res = new Code00084().largestRectangleArea2(k);
        System.out.println(res);
    }

}

package leetcode.stack;

import java.util.PriorityQueue;
import java.util.Stack;

public class Code00042 {
    public int trap(int[] height) {
        if (height.length <= 2) {
            return 0;
        }

        int res = 0;

        for (int i = 1; i < height.length - 1; i++) {
            int max_left = 0, max_right = 0;
            for (int j = i; j >= 0; j--) {
                max_left = Math.max(max_left, height[j]);
            }
            for (int j = i; j < height.length; j++) {
                max_right = Math.max(max_right, height[j]);
            }
            res += Math.min(max_left, max_right) - height[i];
        }

        return res;
    }


    public static void main(String[] args) {
        int[] a = {5, 4, 1, 2};
        System.out.println(new Code00042().trap(a));
    }
}


class Code00042_1 {
    public int trap(int[] height) {
        if (height.length <= 2) {
            return 0;
        }

        int res = 0;
        int now = 0;
        Stack<Integer> stack = new Stack<Integer>();

        while (now < height.length) {
            while (!stack.isEmpty() && height[now] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }

                int distance = now - stack.peek() - 1;
                int bounded_height = Math.min(height[now], height[stack.peek()]) - height[top];
                res += distance * bounded_height;
            }
            stack.push(now++);
        }

        return res;
    }


    public static void main(String[] args) {
        int[] a = {0, 1, 0, 2};
        System.out.println(new Code00042_1().trap(a));
    }
}
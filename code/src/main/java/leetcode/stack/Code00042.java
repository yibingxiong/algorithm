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

class Code00042_2 {
    public int trap(int[] height) {
        if (height.length <= 2) {
            return 0;
        }

        int res = 0;
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];

        max_left[0] = height[0];
        max_right[height.length - 1] = height[height.length - 1];
        for (int i = 1; i < height.length; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i]);
        }

        for (int i = 0; i < height.length; i++) {
            res += Math.min(max_left[i], max_right[i]) - height[i];
        }
        return res;
    }


    public static void main(String[] args) {
        int[] a = {0, 1, 0, 2};
        System.out.println(new Code00042_2().trap(a));
    }
}

class Code00042_3 {
    public int trap(int[] height) {
        if (height.length <= 2) {
            return 0;
        }
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        int maxLeft = 0;
        int maxRight = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= maxLeft) {
                    maxLeft = height[left];
                } else {
                    res += (maxLeft - height[left]);
                }
                left++;
            } else {
                if (height[right] >= maxRight) {
                    maxRight = height[right];
                } else {
                    res += (maxRight - height[right]);
                }
                right--;
            }
        }

        return res;
    }


    public static void main(String[] args) {
        int[] a = {4,3,2,1};
        System.out.println(new Code00042_3().trap(a));
    }
}
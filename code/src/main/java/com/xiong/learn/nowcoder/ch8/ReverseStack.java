package com.xiong.learn.nowcoder.ch8;

import java.util.Stack;

public class ReverseStack {
    public static int getLast(Stack<Integer> stack) {
        int r = stack.pop();
        if (stack.isEmpty()) {
            return  r;
        } else {
            int last = getLast(stack);
            stack.push(r);
            return last;
        }
    }

    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int last = getLast(stack);
        reverse(stack);
        stack.push(last);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        reverse(stack);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}

package leetcode;

import java.util.ArrayDeque;

class MinStack {

	private ArrayDeque<Integer> stack;
	
	private ArrayDeque<Integer> stack2;
	
    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayDeque<>();
       stack2 = new ArrayDeque<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if (stack2.isEmpty() || stack2.peek() >=x) {
        	stack2.push(x);
        }
    }
    
    public void pop() {
    	if (!stack.isEmpty()) {
    		int x = stack.pop();
            
            if (x == stack2.peek()) {
            	stack2.pop();
            }
    	}
        
    }
    
    public int top() {
    	if (!stack.isEmpty()) {    		
    		return stack.peek();
    	}
    	throw new Error();
    }
    
    public int getMin() {
    	if (!stack2.isEmpty()) {
    		return stack2.peek();
    	}
    	throw new Error();
    }
}

public class Code155_MinStack {

    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-1);
		System.out.println(minStack.getMin());
		System.out.println(minStack.top());
		minStack.pop();
		System.out.println(minStack.getMin());
	}

}

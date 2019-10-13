package leetcode;

import java.util.LinkedList;

class MyStack  {

	LinkedList<Integer> queue;

	/** Initialize your data structure here. */
	public MyStack() {
		this.queue = new LinkedList<>();
	}

	/** Push element x onto stack. */
	public void push(int x) {
		this.queue.add(x);
	}

	/** Removes the element on top of the stack and returns that element. */
	public int pop() {
		if (this.queue.isEmpty()) {
			throw new Error("栈为空");
		}
		LinkedList<Integer> q = this.queue;
		LinkedList<Integer> tmp = new LinkedList<>();
		int t = 0;
		if (q.size() == 1) {
			return this.queue.remove();
		}
		int size = q.size();
		while (size > 1) {
			size--;
			t = q.remove();
			tmp.add(t);
		}
		t = q.remove();
		this.queue = tmp;
		return t;
	}

	/** Get the top element. */
	public int top() {
		if (this.queue.isEmpty()) {
			throw new Error("栈为空");
		}
		LinkedList<Integer> q = this.queue;
		LinkedList<Integer> tmp = new LinkedList<>();
		
		int t = 0;
		int size = q.size();
		if (size == 1) {
			int a = q.remove();
			tmp.add(a);
			this.queue = tmp;
			return a;
		}

		while (size > 1) {
			size--;
			t = q.remove();
			tmp.add(t);
		}
		t = q.peek();
		tmp.add(t);
		this.queue = tmp;
		return t;
	}

	/** Returns whether the stack is empty. */
	public boolean empty() {
		return this.queue.isEmpty();
	}
}

public class Code225_MyStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStack aIntegers = new MyStack();
		aIntegers.push(1);
		aIntegers.push(2);
		aIntegers.top();
		aIntegers.pop();
		aIntegers.top();
		aIntegers.top();
//		aIntegers.pop();
		aIntegers.empty();
	}

}

package chapter5;

import java.util.LinkedList;

import chapter5.BinaryTreeTraverse.Node;

public class IsBst {

	public static LinkedList<Integer> list = new LinkedList<>();
	
	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int v) {
			this.value = v;
		}
	}

	public static class ReturnType {
		int max;
		int min;
		boolean isBst;

		public ReturnType(boolean isBst, int max, int min) {
			this.isBst = isBst;
			this.max = max;
			this.min = min;
		}
	}

	public static ReturnType process(Node cur) {
		if (cur == null) {
			return new ReturnType(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
		}
		ReturnType leftReturnType = process(cur.left);
		ReturnType rightReturnType = process(cur.right);
		int min = Math.min(leftReturnType.min, Math.min(rightReturnType.min, cur.value));
		int max = Math.max(leftReturnType.max, Math.max(rightReturnType.max, cur.value));
		boolean isb = leftReturnType.isBst && rightReturnType.isBst && leftReturnType.max < cur.value
				&& rightReturnType.min > cur.value;
		return new ReturnType(isb, max, min);
	}

	public static boolean isBst(Node head) {
		return process(head).isBst;
	}

	// 递归的中序遍历
	public static void inOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		inOrderRecur(head.left);
		list.add(head.value);
		inOrderRecur(head.right);
	}
	
	public static boolean isBst2(Node head) {
		inOrderRecur(head);
		int max = Integer.MIN_VALUE;
		while(!list.isEmpty()) {
			int v = list.poll();
			if (v > max) {
				max = v;
			} else { // 有逆序则不是搜索二叉树
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Node head = new Node(5);
		head.left = new Node(3);
		head.right = new Node(8);
		head.left.left = new Node(2);
		head.left.right = new Node(4);
		head.left.left.left = new Node(1);
		head.right.left = new Node(7);
		head.right.left.left = new Node(6);
		head.right.right = new Node(10);
		head.right.right.left = new Node(9);
		head.right.right.right = new Node(11);

		System.out.println("是否为搜索二叉树判断" + isBst(head));
		
		System.out.println(isBst2(head));

	}

}

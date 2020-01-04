package chapter5;

import chapter5.IsBst.Node;

public class IsBalanceTree {

	public static class Node {
		public Node left;
		public Node right;
		public int value;

		public Node(int v) {
			this.value = v;
		}
	}

	public static class ReturnType {
		public boolean isBalance;
		public int height;

		public ReturnType(boolean isBalance, int height) {
			this.isBalance = isBalance;
			this.height = height;
		}
	}

	public static ReturnType process(Node head) {
		if (head == null) {
			return new ReturnType(true, 0);
		}
		ReturnType leftData = process(head.left);
		ReturnType rightData = process(head.right);
		int height = Math.max(leftData.height, rightData.height) + 1;
		boolean isBalance = Math.abs(leftData.height - rightData.height) <= 1 && leftData.isBalance && rightData.isBalance;

		return new ReturnType(isBalance, height);
	}

	public static boolean isBalance(Node head) {
		return process(head).isBalance;
	}

	// for test
	public static void printTree(Node head) {
		System.out.println("Binary Tree:");
		printInOrder(head, 0, "H", 17);
		System.out.println();
	}

	// for test
	public static void printInOrder(Node head, int height, String to, int len) {
		if (head == null) {
			return;
		}
		printInOrder(head.right, height + 1, "v", len);
		String val = to + head.value + to;
		int lenM = val.length();
		int lenL = (len - lenM) / 2;
		int lenR = len - lenM - lenL;
		val = getSpace(lenL) + val + getSpace(lenR);
		System.out.println(getSpace(height * len) + val);
		printInOrder(head.left, height + 1, "^", len);
	}

	// for test
	public static String getSpace(int num) {
		String space = " ";
		StringBuffer buf = new StringBuffer("");
		for (int i = 0; i < num; i++) {
			buf.append(space);
		}
		return buf.toString();
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
		
		System.out.println("树的结构：");
		printTree(head);
		System.out.println();
		System.out.println("是否为平衡二叉树判断" + isBalance(head));

	}

}

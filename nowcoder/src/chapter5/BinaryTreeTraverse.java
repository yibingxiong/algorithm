package chapter5;

import java.util.Stack;

public class BinaryTreeTraverse {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
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

	// 递归的先序遍历
	public static void preOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		System.out.print(head.value + "  ");
		preOrderRecur(head.left);
		preOrderRecur(head.right);
	}

	// 递归的中序遍历
	public static void inOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		inOrderRecur(head.left);
		System.out.print(head.value + "  ");
		inOrderRecur(head.right);
	}

	// 递归的后序遍历
	public static void posOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		posOrderRecur(head.left);
		posOrderRecur(head.right);
		System.out.print(head.value + "  ");
	}

	// 非递归先序遍历
	public static void preOrderUnRecur(Node head) {
		if (head == null) {
			return;
		}
		Stack<Node> stack = new Stack<>();
		stack.add(head);

		while (!stack.isEmpty()) {
			Node cur = stack.pop();
			System.out.print(cur.value + "  ");
			if (cur.right != null) {
				stack.add(cur.right);
			}
			if (cur.left != null) {
				stack.add(cur.left);
			}

		}
	}

	// 非递归后序遍历
	public static void posOrderUnRecur1(Node head) {
		if (head == null) {
			return;
		}
		Stack<Node> stack1 = new Stack<>();
		Stack<Node> stack2 = new Stack<>();
		stack1.add(head);
		while (!stack1.isEmpty()) {
			Node cur = stack1.pop();
			stack2.add(cur);
			if (cur.left != null) {
				stack1.add(cur.left);
			}
			if (cur.right != null) {
				stack1.add(cur.right);
			}
		}

		while (!stack2.isEmpty()) {
			System.out.print(stack2.pop().value + "  ");
		}
	}

	public static void inOrderUnRecur(Node head) {
		if (head != null) {
			Stack<Node> stack = new Stack<Node>();
			while (!stack.isEmpty() || head != null) {
				if (head != null) {
					stack.push(head);
					head = head.left;
				} else {
					head = stack.pop();
					System.out.print(head.value + " ");
					head = head.right;
				}
			}
		}
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

		System.out.println("原二叉树：");
		printTree(head);
		System.out.println();
		// recursive
		System.out.println("==============recursive==============");
		System.out.print("pre-order: ");
		preOrderRecur(head);
		System.out.println();
		System.out.print("in-order: ");
		inOrderRecur(head);
		System.out.println();
		System.out.print("pos-order: ");
		posOrderRecur(head);
		System.out.println();
//
//		// unrecursive
		System.out.println("============unrecursive=============");
		System.out.print("pre-order: ");
		preOrderUnRecur(head);
		System.out.println();
		System.out.print("in-order: ");
		inOrderUnRecur(head);
		System.out.println();
		System.out.print("pos-order: ");
		posOrderUnRecur1(head);
		System.out.println();
//		posOrderUnRecur2(head);

	}

}

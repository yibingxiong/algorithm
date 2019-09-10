package chapter5;

import java.util.LinkedList;

import chapter5.IsBst.Node;

public class IsCompleteTree {

	public static class Node {
		Node left;
		Node right;
		int value;

		public Node(int value) {
			this.value = value;
		}
	}

	public static boolean isComplete(Node head) {
		if (head == null) {
			return true;
		}
		LinkedList<Node> list = new LinkedList<>();
		boolean isStartLeaf = false; // 是否走到了第一个两个孩子不全的节点
		list.add(head);
		while (!list.isEmpty()) {
			head = list.poll();
			if (head.right != null && head.left == null) { // 右孩子有左孩子没有， 不完全

				return false;
			}

			if (isStartLeaf && (head.right != null || head.left != null)) { // 走到一个两个孩子不全的节点后，后续所有节点必须都是叶节点
				System.out.println(head.value);
				return false;
			}
			if (head.right == null || head.left == null) {
				isStartLeaf = true;
			}
			if (head.left != null) {
				list.add(head.left);
			}
			if (head.right != null) {
				list.add(head.right);
			}
		}
		return true;
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
//		head.right.left.left = new Node(6);
		head.right.right = new Node(10);
//		head.right.right.left = new Node(9);
//		head.right.right.right = new Node(11);

		System.out.println("打印二叉树");
		printTree(head);
		System.out.println();
		System.out.println("是否为完全二叉树判断" + isComplete(head));

	}

}

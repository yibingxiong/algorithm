package chapter5;

public class LowestCommonAncestor {

	public static class Node {
		Node left;
		Node right;
		int value;

		public Node(int value) {
			this.value = value;
		}
	}

	public static Node lowestAncestor(Node head, Node o1, Node o2) {
		if (head == null || head == o1 || head == o2) {
			return head;
		}
		Node left = lowestAncestor(head.left, o1, o2);
		Node right = lowestAncestor(head.right, o1, o2);
		if (left != null && right != null) {
			return head;
		}
		return left != null ? left : right;
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
		Node node3 = new Node(3);
		head.left = node3;
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
		Node a = lowestAncestor(head, node3, head.right.right);
		System.out.println("是否为平衡二叉树判断" + a == null ? "" : a.value);

	}

}

package chapter5;

import java.util.LinkedList;

import chapter5.IsCompleteTree.Node;

public class Serialize {

	public static class Node {
		Node left;
		Node right;
		int value;

		public Node(int value) {
			this.value = value;
		}
	}

	// 序列化
	public static String serializeTree(Node head) {
		if (head == null) {
			return "#_";
		}
		String res = head.value + "_";
		res = res + serializeTree(head.left) + serializeTree(head.right);
		return res;
	}
	
	
	// 反序列化
	public static Node deserializeTree(String str) {
		LinkedList<String> list = new LinkedList<>();
		String strArr[]  = str.split("_");
		for (int i = 0; i< strArr.length; i++) {
			list.add(strArr[i]);
		}
		return deserializeTreeProcess(list);
	}
	
	public static Node deserializeTreeProcess(LinkedList<String> strList) {
		String v = strList.poll();
		if (v.equals("#")) {
			return null;
		}
		Node hNode = new Node(Integer.valueOf(v));
		hNode.left = deserializeTreeProcess(strList);
		hNode.right = deserializeTreeProcess(strList);
		return hNode;
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
		System.out.println("打印树");
		printTree(head);;
		String serializeStr = serializeTree(head);
		System.out.println("序列化结果:" + serializeStr);
		Node deserializeNode = deserializeTree(serializeStr);
		System.out.println("反序列化结果：");
		printTree(deserializeNode);

	}

}

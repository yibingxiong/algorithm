package chapter5;

import java.util.HashMap;
import java.util.LinkedList;

import chapter5.BinaryTreeTraverse.Node;

public class Bfs {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	public static int getMaxWidth(Node head) {
		if (head == null) {
			return 0;
		}

		LinkedList<Node> queue = new LinkedList<>();
		queue.add(head);
		HashMap<Node, Integer> nodeLevelMap = new HashMap<>();
		nodeLevelMap.put(head, 1);
		int max = 0;
		int maxLevel = 1;
		int calLevelNum = 0; // 当前统计层统计到多少个节点
		int curCalLevel = 0; // 当前统计到第几层
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			int curLevel = nodeLevelMap.get(cur); // 当前节点的层数
			if (curCalLevel == curLevel) { // 当前统计的层数和当前节点的层级一样
				calLevelNum++;
			} else { // 说明一层统计完了, 到了下一层第一个
				if (calLevelNum > max) {
					max = calLevelNum;
					maxLevel = curCalLevel;
				}
				curCalLevel = curLevel;
				calLevelNum = 1;
			}
			System.out.println(cur.value);
			if (cur.left != null) {
				nodeLevelMap.put(cur.left, curLevel + 1);
				queue.add(cur.left);
			}
			if (cur.right != null) {
				nodeLevelMap.put(cur.right, curLevel + 1);
				queue.add(cur.right);
			}
		}
		System.out.println("最大宽度所在层为" + maxLevel);
		return max;
	}

	// for test
	public static void printTree(Node head) {
		System.out.println("Binary Tree:");
		printInOrder(head, 0, "H", 17);
		System.out.println();
	}

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
//		head.right.right.right = new Node(11);

		printTree(head);
		System.out.println("树的最大宽度为：");
		System.out.println(getMaxWidth(head));
	}

}

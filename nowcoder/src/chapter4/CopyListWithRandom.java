package chapter4;

import java.util.HashMap;

public class CopyListWithRandom {
	public static class Node {
		public int value;
		public Node next;
		public Node rand;

		public Node(int data) {
			this.value = data;
		}
	}

	public static void printRandLinkedList(Node head) {
		Node cur = head;
		System.out.print("order: ");
		while (cur != null) {
			System.out.print(cur.value + " ");
			cur = cur.next;
		}
		System.out.println();
		cur = head;
		System.out.print("rand:  ");
		while (cur != null) {
			System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
			cur = cur.next;
		}
		System.out.println();
	}

	// 使用HashMap来做
	public static Node copyListWithRand1(Node head) {
		HashMap<Node, Node> hashMap = new HashMap<>();
		Node cur = head;
		while (cur != null) {
			Node cloneNode = new Node(cur.value);
			hashMap.put(cur, cloneNode);
			cur = cur.next;
		}
		cur = head;
		while (cur != null) {
			hashMap.get(cur).next = hashMap.get(cur.next);
			hashMap.get(cur).rand = cur.rand != null ? hashMap.get(cur.rand) : null;
			cur = cur.next;
		}

		return hashMap.get(head);
	}

	// 不用额外空间来做
	public static Node copyListWithRand2(Node head) {
		Node cur = head;
		
		// 将当前节点的克隆节点放到当前节点的下一个
		while (cur != null) {
			Node next = cur.next;
			Node cloneNode = new Node(cur.value);
			cur.next = cloneNode;
			cur.next.next = next;
			cur = next;
		}
		
		// 设置克隆节点的random指针
		cur = head;
		while(cur!=null) {
			Node originNode = cur;
			Node cloneNode = cur.next;
			Node nextOriginNode = cloneNode.next;
			cloneNode.rand =originNode.rand!=null? originNode.rand.next : null;
			cur = nextOriginNode;
		}
		// next方向分离
		cur = head;
		Node firstCloneNode = head.next;
		while(cur!=null) {
			Node originNode = cur;
			Node cloneNode = cur.next;
			Node nextOriginNode = cloneNode.next;
			Node nextCloneNode = nextOriginNode!=null?nextOriginNode.next:null;
			originNode.next = nextOriginNode;
			cloneNode = nextCloneNode;
			cur = nextOriginNode;
		}
		return firstCloneNode;
	}

	public static void main(String[] args) {
		Node head = null;
		Node res1 = null;
		Node res2 = null;
		printRandLinkedList(head);
		res1 = copyListWithRand1(head);
		printRandLinkedList(res1);
		printRandLinkedList(res2);
		printRandLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);

		head.rand = head.next.next.next.next.next; // 1 -> 6
		head.next.rand = head.next.next.next.next.next; // 2 -> 6
		head.next.next.rand = head.next.next.next.next; // 3 -> 5
		head.next.next.next.rand = head.next.next; // 4 -> 3
		head.next.next.next.next.rand = null; // 5 -> null
		head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

		printRandLinkedList(head);
		res1 = copyListWithRand1(head);
		printRandLinkedList(res1);
		res2 = copyListWithRand2(head);
		System.out.println(res2 == head);
		printRandLinkedList(res2);
		printRandLinkedList(head);
		System.out.println("=========================");
	}

}

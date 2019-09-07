package chapter4;

import java.util.Stack;


public class IsPalindromeList {

	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}

	// 使用栈实现
	public static boolean isPalindromeList1(Node head) {
		Stack<Node> stack = new Stack<>();
		Node head1 = head;
		while (head1 != null) {
			stack.add(head1);
			head1 = head1.next;
		}
		while (head != null) {
			if (head.value != stack.pop().value) {
				return false;
			}
			head = head.next;
		}
		return true;
	}

	// 使用半个栈实现判断是否回文
	public static boolean isPalindromeList2(Node head) {
		Node cur1 = head;
		Node cur2 = head;
		while (cur1 != null && cur2 != null && cur2.next != null && cur2.next.next != null) {
			cur1 = cur1.next;
			cur2 = cur2.next.next;
		}
		Stack<Node> stack = new Stack<>();
		cur1 = cur1 != null ? cur1.next : cur1;
		while (cur1 != null) {
			stack.add(cur1);
			cur1 = cur1.next;
		}
		while (!stack.isEmpty() && head != null) {
			if (head == null || stack.pop().value != head.value) {
				return false;
			}
			head = head.next;
		}
		return true;
	}

	public static boolean isPalindromeList3(Node head) {
		if (head == null || head.next == null) {
			return true;
		}
		Node n1 = head;
		Node n2 = head;
		while (n2.next != null && n2.next.next != null) { // find mid node
			n1 = n1.next; // n1 -> mid
			n2 = n2.next.next; // n2 -> end
		}
		n2 = n1.next; // n2 -> right part first node
		n1.next = null; // mid.next -> null
		Node n3 = null;
		while (n2 != null) { // right part convert
			n3 = n2.next; // n3 -> save next node
			n2.next = n1; // next of right node convert
			n1 = n2; // n1 move
			n2 = n3; // n2 move
		}
		n3 = n1; // n3 -> save last node
		n2 = head;// n2 -> left first node
		boolean res = true;
		while (n1 != null && n2 != null) { // check palindrome
			if (n1.value != n2.value) {
				res = false;
				break;
			}
			n1 = n1.next; // left to mid
			n2 = n2.next; // right to mid
		}
		n1 = n3.next;
		n3.next = null;
		while (n1 != null) { // recover list
			n2 = n1.next;
			n1.next = n3;
			n3 = n1;
			n1 = n2;
		}

		return res;
	}

	// for test
	public static void printLinkedList(Node node) {
		System.out.print("Linked List: ");
		while (node != null) {
			System.out.print(node.value + " ");
			node = node.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node head = null;
		printLinkedList(head);
		System.out.println(isPalindromeList1(head));
		System.out.println(isPalindromeList2(head));
		System.out.println(isPalindromeList3(head));
		printLinkedList(head);
		System.out.println("=========================1");

		head = new Node(1);
		printLinkedList(head);
		System.out.println(isPalindromeList1(head));
		System.out.println(isPalindromeList2(head));
		System.out.println(isPalindromeList3(head));
		printLinkedList(head);
		System.out.println("=========================2");

		head = new Node(1);
		head.next = new Node(2);
		printLinkedList(head);
		System.out.println(isPalindromeList1(head));
		System.out.println(isPalindromeList2(head));
		System.out.println(isPalindromeList3(head));
		printLinkedList(head);
		System.out.println("=========================3");

		head = new Node(1);
		head.next = new Node(1);
		printLinkedList(head);
		System.out.println(isPalindromeList1(head));
		System.out.println(isPalindromeList2(head));
		System.out.println(isPalindromeList3(head));
		printLinkedList(head);
		System.out.println("=========================4");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		printLinkedList(head);
		System.out.println(isPalindromeList1(head));
		System.out.println(isPalindromeList2(head));
		System.out.println(isPalindromeList3(head));
		printLinkedList(head);
		System.out.println("=========================5");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(1);
		printLinkedList(head);
		System.out.println(isPalindromeList1(head));
		System.out.println(isPalindromeList2(head));
		System.out.println(isPalindromeList3(head));
		printLinkedList(head);
		System.out.println("=========================6");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(1);
		printLinkedList(head);
		System.out.println(isPalindromeList1(head));
		System.out.println(isPalindromeList2(head));
		System.out.println(isPalindromeList3(head));
		printLinkedList(head);
		System.out.println("=========================7");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(2);
		head.next.next.next = new Node(1);
		printLinkedList(head);
		System.out.println(isPalindromeList1(head));
		System.out.println(isPalindromeList2(head));
		System.out.println(isPalindromeList3(head));
		printLinkedList(head);
		System.out.println("=========================8");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(2);
		head.next.next.next.next = new Node(1);
		printLinkedList(head);
		System.out.println(isPalindromeList1(head));
		System.out.println(isPalindromeList2(head));
		System.out.println(isPalindromeList3(head));
		printLinkedList(head);
		System.out.println("=========================9");

	}

}

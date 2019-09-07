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
		while(head1!=null) {
			stack.add(head1);
			head1 = head1.next;
		}
		while(head!=null) {
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
		while(cur1!=null && cur2!=null && cur2.next!=null && cur2.next.next!=null) {
			cur1 = cur1.next;
			cur2 = cur2.next.next;
		}
		Stack<Node> stack = new Stack<>();
		cur1 = cur1!=null ? cur1.next: cur1;
		while(cur1!=null) {
			stack.add(cur1);
			cur1 = cur1.next;
		}
		while(!stack.isEmpty() && head!=null) {
			if (head==null || stack.pop().value != head.value) {
				return false;
			}
			head = head.next;
		}
		return true;
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
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		printLinkedList(head);
		System.out.println(isPalindromeList1(head));
		System.out.println(isPalindromeList2(head));
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		printLinkedList(head);
		System.out.println(isPalindromeList1(head));
		System.out.println(isPalindromeList2(head));
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(1);
		printLinkedList(head);
		System.out.println(isPalindromeList1(head));
		System.out.println(isPalindromeList2(head));
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		printLinkedList(head);
		System.out.println(isPalindromeList1(head));
		System.out.println(isPalindromeList2(head));
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(1);
		printLinkedList(head);
		System.out.println(isPalindromeList1(head));
		System.out.println(isPalindromeList2(head));
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(1);
		printLinkedList(head);
		System.out.println(isPalindromeList1(head));
		System.out.println(isPalindromeList2(head));
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(2);
		head.next.next.next = new Node(1);
		printLinkedList(head);
		System.out.println(isPalindromeList1(head));
		System.out.println(isPalindromeList2(head));
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(2);
		head.next.next.next.next = new Node(1);
		printLinkedList(head);
		System.out.println(isPalindromeList1(head));
		System.out.println(isPalindromeList2(head));
		printLinkedList(head);
		System.out.println("=========================");

	}

}

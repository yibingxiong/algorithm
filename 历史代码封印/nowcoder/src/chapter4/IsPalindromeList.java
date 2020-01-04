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

	// 纯使用指针判断是否是回文
	// 这里考虑保存几个重要指针 中间指针， 中间指针的下一个， 最后一个， 以便于在恢复链表使用
	public static boolean isPalindromeList3(Node head) {
		if (head == null || head.next == null) {
			return true;
		}
		Node slow = head;
		Node fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		// 上边几行走完，slow来到中间节点
		Node mid = slow;	// 记录中间节点， 待会儿翻转他之后的节点
		
		Node rightFirst = slow.next;	// 右边部分的第一个节点， 需要翻转
		mid.next = null;	// 将中间节点的下一个节点指到空， 避免成环
		Node pre = null;
		// 将右边部分翻转
		Node cur = rightFirst;
		while (cur != null) { // right part convert
			Node next = cur.next; // n3 -> save next node
			cur.next = pre; // next of right node convert
			pre = cur;
			cur = next;
		}
		Node reverseRightFirst = pre;	// 右侧翻转后的第一个节点
		Node cur1 = head;	// 左链遍历的当前节点
		Node cur2 = reverseRightFirst;	// 右链遍历的当前节点
		boolean res = true;
		while (cur1 != null && cur2 != null) {
			if (cur1.value != cur2.value) {
				res = false;
				break;
			}
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		
		cur1 = null;	// 前一个
		cur2 = reverseRightFirst;	// 当前
		// 将右侧翻转的部分翻转回来
		while (cur2 != null) { // recover list
			Node next = cur2.next;
			cur2.next = cur1;
			cur1 = cur2;
			cur2 = next;
		}
		
		// 将中间节点连到 右边第一个节点
		mid.next = rightFirst;
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

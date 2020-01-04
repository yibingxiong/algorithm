package chapter4;

import java.util.HashSet;

public class IsLoop {

	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}
	
	// 使用hasSet来做
	public static Node isLoop1(Node head) {
		HashSet<Node> hashSet = new HashSet<>();
		Node cur = head;
		while(cur!=null) {
			if (hashSet.contains(cur)) {
				return cur;
			}
			hashSet.add(cur);
			cur = cur.next;
		}
		return null;
	}
	
	// 使用快慢指针判断单链表是否有环
	public static Node isLoop2(Node head) {
		if (head == null || head.next ==null || head.next.next == null) {
			return null;
		}
		Node fast = head.next.next, slow = head.next;
		
		while(fast != slow) {
			if(fast==null || fast.next == null || fast.next.next ==null ) {
				return null;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		
		fast = head;
		
		while(fast != null && slow!=null) {
			if (fast == slow) {
				return fast;
			}
			fast = fast.next;
			slow = slow.next;
		}
		return null;
	}
	
	public static void print(Node a) {
		if(a!=null) {
			System.out.println(a.value);
		} else {
			System.out.println("五环");
		}
	}
	public static void main(String[] args) {
		Node head = new Node(0);
		Node node1  = new Node(1);
		Node node2  = new Node(2);
		Node node3  = new Node(3);
		Node node4  = new Node(4);
		Node node5  = new Node(5);
		
		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node1;
		
		Node k = isLoop1(head);
		Node k2 = isLoop2(head);
		print(k);
		print(k2);
		
		System.out.println("=============");
		head.next = node1;
		head.next.next = node2;
		head.next.next.next = node3;
		head.next.next.next.next = node4;
		
		k = isLoop1(head);
		k2 = isLoop2(head);
		print(k);
		print(k2);

	}

}

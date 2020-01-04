package chapter4;

public class ReverseList {
	
	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}
	
	public static class DoubleNode {
		public int value;
		public DoubleNode last;
		public DoubleNode next;

		public DoubleNode(int data) {
			this.value = data;
		}
	}

	public static Node reverseList(Node node) {
		Node next = null;
		Node pre = null;
		while(node!=null) {
			next = node.next;
			node.next = pre;
			pre  = node;
			node = next;
		}
		return pre;
	}
	
	public static DoubleNode reverseDoubleList(DoubleNode head) {
		DoubleNode pre = null;
		DoubleNode next = null;
		
		while(head != null) {
			next = head.next;
			head.last = next;
			head.next = pre;
			pre = head;
			head = next;
			
		}
		return pre;
	}
	
	public static void printLinkedList(Node head) {
		System.out.print("Linked List: ");
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
		System.out.println();
	}
	
	public static void printDoubleLinkedList(DoubleNode head) {
		System.out.print("Double Linked List: ");
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Node head1 = new Node(1);
		Node node1 = new Node(2);
		Node node2 = new Node(3);
		head1.next = node1;
		node1.next = node2;
		printLinkedList(head1);
		Node head2 = reverseList(head1);
		printLinkedList(head2);
		
		
		DoubleNode node11 = new DoubleNode(1);
		DoubleNode node12 = new DoubleNode(2);
		DoubleNode node13 = new DoubleNode(3);
		
		node11.next = node12;
		node12.next = node13;
		node13.last = node12;
		node12.last = node11;
		
		DoubleNode h1 = node11;
		printDoubleLinkedList(h1);
		DoubleNode h2 =  reverseDoubleList(h1);
		printDoubleLinkedList(h2);
		
		

	}

}

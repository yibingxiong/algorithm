package chapter4;

public class ListPartition {

	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}

	public static Node listPartion1(Node head, int p) {
		if (head == null) {
			return null;
		}
		int len = 0;
		Node cur = head;
		while (cur != null) {
			len++;
			cur = cur.next;
		}

		if (len == 1) {
			return head;
		}

		Node[] nodeArr = new Node[len];
		cur = head;
		len = 0;

		while (cur != null) {
			nodeArr[len++] = cur;
			cur = cur.next;
		}

		nodeArrPartition(nodeArr, p);

		for (int i = 0; i < nodeArr.length - 1; i++) {
			nodeArr[i].next = nodeArr[i + 1];
		}

		nodeArr[len - 1].next = null;

		return nodeArr[0];
	}

	public static void nodeArrPartition(Node[] nodeArr, int p) {
		int less = -1;
		int more = nodeArr.length;
		int now = 0;
		while (now < more) {
			Node cur = nodeArr[now];
			int v = cur.value;
			if (v < p) {
				swap(nodeArr, ++less, now);
				now++;
			} else if (v > p) {
				swap(nodeArr, now, --more);
			} else {
				now++;
			}
		}

	}

	public static void swap(Node[] nodeArr, int i, int j) {
		Node tmp = nodeArr[i];
		nodeArr[i] = nodeArr[j];
		nodeArr[j] = tmp;
	}

	public static void printLinkedList(Node node) {
		System.out.print("Linked List: ");
		while (node != null) {
			System.out.print(node.value + " ");
			node = node.next;
		}
		System.out.println();
	}

	public static Node listPartion2(Node head, int p) {
		Node sH = null, sT = null, eH = null, eT = null, bH = null, bT = null;

		while (head != null) {
			if (head.value < p) {
				if (sH == null) {
					sT = sH = head;
				} else {
					sT.next = head;
					sT = head;
				}
			} else if (head.value > p) {
				if (bH == null) {
					bT = bH = head;
				} else {
					bT.next = head;
					bT = head;
				}
			} else {
				if (eH == null) {
					eT = eH = head;
				} else {
					eT.next = head;
					eT = head;
				}
			}
			head = head.next;
		}
		
		Node newHead = sH !=null?sH: eH!=null?eH:bH;	// 最后连接成的链的头结点
		
		
		if (sT !=null) {
			sT.next = eH!=null?eH:bH;
		} else if (eT!=null) {
			eT.next = bH;
		}
		
		if (eT !=null) {
			eT.next = bH;
		}
		
		if (bT !=null) {
			bT.next = null;
		}
		
		return newHead;
	}

	public static void main(String[] args) {
		Node head1 = new Node(7);
		head1.next = new Node(9);
		head1.next.next = new Node(1);
		head1.next.next.next = new Node(8);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(2);
		head1.next.next.next.next.next.next = new Node(5);
		printLinkedList(head1);
//		head1 = listPartion1(head1, 4); 
//		head1 = listPartion1(head1, 5);
//		head1 = listPartion2(head1, 5);
		head1 = listPartion2(head1, 4); 
		printLinkedList(head1);
	}

}

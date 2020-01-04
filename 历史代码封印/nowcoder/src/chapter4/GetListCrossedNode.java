package chapter4;


public class GetListCrossedNode {
	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}

	// 使用快慢指针判断单链表是否有环
	public static Node isLoop2(Node head) {
		if (head == null || head.next == null || head.next.next == null) {
			return null;
		}
		Node fast = head.next.next, slow = head.next;

		while (fast != slow) {
			if (fast == null || fast.next == null || fast.next.next == null) {
				return null;
			}
			slow = slow.next;
			fast = fast.next.next;
		}

		fast = head;

		while (fast != null && slow != null) {
			if (fast == slow) {
				return fast;
			}
			fast = fast.next;
			slow = slow.next;
		}
		return null;
	}

	// 无环单链表相交节点
	public static Node getNoLoopCrossedNode(Node head1, Node head2) {
		int len1 = 0;
		int len2 = 0;
		Node cur = head1;
		Node last1 = null;
		Node last2 = null;
		while (cur != null) {
			len1++;
			last1 = cur;
			cur = cur.next;
		}
		cur = head2;
		while (cur != null) {
			len2++;
			last2 = cur;
			cur = cur.next;
		}
		if (last1 != last2) { // 连个无环链表最后一个节点不一样一定不相交
			return null;
		}

		Node longList = len1 > len2 ? head1 : head2;
		Node shortList = longList == head1 ? head2 : head1;
		int diff = Math.abs(len1 - len2);
		int hasGo = 0;
		// 长的先走差值部分
		cur = longList;
		while (++hasGo <= diff) {
			cur = cur.next;
		}

		while (cur != shortList) {
			cur = cur.next;
			shortList = shortList.next;
		}
		return cur;
	}
	
	public static Node getBothLoopCrossedNode(Node head1, Node head2, Node loop1, Node loop2) {
		if (loop1 == loop2) {	// 在入环之前就相交了
			// 跟两个无环单链表相交问题一样
			Node cur = head1;
			int len1 = 0;
			int len2 = 0;
			while(cur != loop1) {
				len1++;
				cur = cur.next;
			}
			cur = head2;
			while(cur != loop1) {
				len2++;
				cur = cur.next;
			}
			
			Node longList = len1 > len2? head1:head2;
			Node shortList = longList == head1?head2:head1;
			
			int hasGo = 0;
			while(++hasGo <= Math.abs(len1-len2)) {
				longList = longList.next;
			}
			
			while (longList != shortList) {
				longList = longList.next;
				shortList = shortList.next;
			}
			return longList;
			
		} else {
			Node cur = loop2.next;
			// 转一圈
			while(cur!=loop2) {
				if (cur == loop1) {
					return cur;
				}
				cur = cur.next;
			}
			// 转一圈都没遇到
			return null;
		}
	}

	public static Node getIntersectNode(Node head1, Node head2) {
		Node loop1 = isLoop2(head1);
		Node loop2 = isLoop2(head2);
		if (loop1==null && loop2 == null) {	// 两个都无环
			return getNoLoopCrossedNode(head1, head2);
		} else if(loop1!=null && loop2!=null) {	// 两个都有环
			return getBothLoopCrossedNode(head1, head2, loop1, loop2);
		} else {	// 一个有环一个无环， 必定不相交
			return null;
		}
	}
	
	public static void main(String[] args) {
		// 1->2->3->4->5->6->7->null
		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		head1.next.next.next.next.next.next = new Node(7);

		// 0->9->8->6->7->null
		Node head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next.next.next.next.next; // 8->6
		System.out.println(getIntersectNode(head1, head2).value);

		// 1->2->3->4->5->6->7->4...
		head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		head1.next.next.next.next.next.next = new Node(7);
		head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

		// 0->9->8->2...
		head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next; // 8->2
		System.out.println(getIntersectNode(head1, head2).value);

		// 0->9->8->6->4->5->6..
		head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next.next.next.next.next; // 8->6
		System.out.println(getIntersectNode(head1, head2).value);
	}

}

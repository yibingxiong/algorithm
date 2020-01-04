package leetcode;

public class Code203_removeElements {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode removeElements(ListNode head, int val) {
		ListNode pre = null;
		ListNode newHead = null;
		while (head != null) {
			if (head.val == val) {
				if (pre != null) {
					pre.next = head.next;
				}
				head = head.next;
			} else {
				if (newHead == null) {
					newHead = head;
				}
				pre = head;
				head = head.next;
			}
		}
		return newHead;
	}

	public static void printlist(ListNode ls) {
		while (ls != null) {
			System.out.println(ls.val);
			ls = ls.next;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);

		ListNode h = removeElements(head, 4);

		printlist(h);
	}

}

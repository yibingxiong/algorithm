package leetcode;

public class Code021_MergeTwoLists {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		ListNode head = null;
		if (l1.val < l2.val) {
			head = l1;
			l1 = l1.next;
		} else {
			head = l2;
			l2 = l2.next;
		}

		ListNode cur = head;
		while (l1 != null || l2 != null) {
			if (l1 != null && l2 != null) {
				int v1 = l1.val;
				int v2 = l2.val;
				if (v1 < v2) {
					cur.next = l1;
					l1 = l1.next;
				} else {
					cur.next = l2;
					l2 = l2.next;
				}
				cur = cur.next;
			} else {
				l1 = l1 == null?l2:l1;
				cur.next = l1;
				l1 = null;
				l2 = null;
			}
		}
		return head;
	}

	public static void printList(ListNode h) {
		while(h !=null) {
			System.out.println(h.val);
			h = h.next;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1->2->4, 1->3->4
		ListNode h = new ListNode(1);
		h.next = new ListNode(2);
		h.next.next = new ListNode(4);
		
		ListNode h2 = new ListNode(1);
		h2.next = new ListNode(3);
		h2.next.next = new ListNode(4);
		
		ListNode res = mergeTwoLists(h, h2);
		
		printList(res);
	}

}

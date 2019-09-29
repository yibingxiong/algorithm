package leetcode;

import java.util.HashSet;

public class Code141_hasCycle {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public boolean hasCycle(ListNode head) {
		if (head == null) {
			return false;
		}

		HashSet<ListNode> hs = new HashSet<>();

		while (head != null) {
			if (hs.contains(head)) {
				return true;
			}
			hs.add(head);
			head = head.next;
		}

		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

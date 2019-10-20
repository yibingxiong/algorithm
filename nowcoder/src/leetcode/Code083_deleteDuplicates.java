package leetcode;

import java.util.HashSet;

class ListNode1 {
	int val;
	ListNode1 next;

	ListNode1(int x) {
		val = x;
	}
}

public class Code083_deleteDuplicates {

	public static ListNode1 deleteDuplicates(ListNode1 head) {
		HashSet<Integer> hashSet = new HashSet<>();

		ListNode1 cur = null;
		ListNode1 newHead = null;
		while (head != null) {
			if (hashSet.contains(head.val)) {

			} else {
				hashSet.add(head.val);
				System.out.println("dd" +head.val);
				if (newHead == null) {
					newHead = cur = new ListNode1(head.val);
				} else {
					cur.next = new ListNode1(head.val);
					cur = cur.next;
				}
			}
			head = head.next;
		}

		return newHead;

	}

	public static void print(ListNode1 ls) {
		while(ls!=null) {
			System.out.println(ls.val);
			ls = ls.next;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode1 ls = new ListNode1(1);
		ls.next = new ListNode1(1);
		ls.next.next = new ListNode1(2);
		ls.next.next.next = new ListNode1(3);
		ls.next.next.next.next = new ListNode1(3);
		
		ListNode1 ll = deleteDuplicates(ls);
		
		print(ll);
	}

}

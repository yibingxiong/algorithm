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
		
		if (head == null) {
			return head;
		}
		
		ListNode1 pointer1 = head;
		ListNode1 pointer2 = head.next;
		ListNode1 newHead = pointer1;
		if (pointer2 == null) {
			return head;
		}
		pointer1.next = null;
		while(pointer2!=null) {
			if (pointer1.val != pointer2.val) {
				System.out.println("cc"+pointer1.val);
				pointer1.next = new ListNode1(pointer2.val);
				pointer1 = pointer1.next;
			}
			pointer2 = pointer2.next;
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

package leetcode;

import java.util.Stack;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class Code234_isPalindrome {

	public boolean isPalindrome(ListNode head) {
		Stack<Integer> s = new Stack<>();
		ListNode cur = head;
		while(cur != null) {
			s.push(cur.val);
			cur = cur.next;
		}
		
		while(!s.isEmpty()) {
			if (s.pop() != head.val) {
				return false;
			}
			head = head.next;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/**
 * 一开始理解错题意了，忽略了逆序两个字， 导致卡了很久，把问题搞复杂了
 */
package leetcode;

import java.util.LinkedList;
import java.util.Stack;

public class Code002_AddTwoNumbers {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		LinkedList<ListNode> list = new LinkedList<>();
		ListNode cur = l1;
		int jinwei = 0;
		while(l1!=null || l2!=null) {
			if (l1!=null && l2!=null) {	// 都有
				int v = l1.val + l2.val + jinwei;
				if (v<10) {
					list.add(new ListNode(v));
					jinwei = 0;
				} else {
					int m = v /10;
					int n = v - m*10;
					jinwei = m;
					list.add(new ListNode(n));
				}
				l1 = l1.next;
				l2 = l2.next;
			} else {
				l1 = l1!=null?l1:l2;;
				while(l1!=null) {
					int v = l1.val + jinwei;
					if (v<10) {
						list.add(new ListNode(v));
						jinwei = 0;
					} else {
						int m = v /10;
						int n = v - m*10;
						jinwei = m;
						list.add(new ListNode(n));
					}
					l1 = l1.next;
				}
				l1 = null;
				l2 = null;
			}
		}
		if (jinwei > 0) {
			list.add(new ListNode(jinwei));
		}
		cur = null;
		ListNode h = null;
		while(!list.isEmpty()) {
			if (cur == null) {
				cur = list.poll();
				h = cur;
			} else {
				cur.next = list.poll();
				cur = cur.next;
			}
		}
		return h;
	}

	public static void printList(ListNode h) {
		System.out.println("结果是：");
		while(h!=null) {
			System.out.println(h.val);
			h = h.next;
		}
	}
	public static void main(String[] args) {
		ListNode l1 = new ListNode(0);
//		l1.next = new ListNode(4);
//		l1.next.next = new ListNode(3);
		printList(l1);
		ListNode l2 = new ListNode(7);
		l2.next = new ListNode(3);
//		l2.next.next = new ListNode(4);
		printList(l2);
		ListNode res = addTwoNumbers(l1, l2);
		
		printList(res);

	}

}

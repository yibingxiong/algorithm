import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class Code023_mergeKLists {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static class CompratorA implements Comparator<ListNode> {

		@Override
		public int compare(ListNode o1, ListNode o2) {
			// TODO Auto-generated method stub
			return o1.val - o2.val;
		}

	}

	public static ListNode mergeKLists(ListNode[] lists) {
		ListNode[] sortL = getMinList(lists);
		ListNode head = null;
		ListNode res = null;
		while (sortL != null) {
			ListNode cur = sortL[0];
			if (head == null) {
				head = new ListNode(cur.val);
				res = head;
			} else {
				head.next = new ListNode(cur.val);
				head = head.next;
			}
			
			cur = cur.next;
			sortL[0] = cur;
			sortL = getMinList(sortL);
		}
		return res;
	}

	public static ListNode[] getMinList(ListNode[] lists) {
		Stack<ListNode> s = new Stack<>();
		for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null) {
				s.add(lists[i]);
			}
		}
		if (s.isEmpty()) {
			return null;
		}

		ListNode[] l = new ListNode[s.size()];
		int i = 0;
		while (!s.isEmpty()) {
			l[i++] = s.pop();
		}

		Arrays.sort(l, new CompratorA());

		return l;
	}

	public static void printList(ListNode h) {
		while (h != null) {
			System.out.println(h.val);
			h = h.next;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(5);

		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);

		ListNode l3 = new ListNode(2);
		l3.next = new ListNode(6);

		ListNode[] a = { l1, l2, l3 };
		ListNode b  = mergeKLists(a);
		printList(b);

	}

}

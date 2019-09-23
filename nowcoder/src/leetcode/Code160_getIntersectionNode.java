package leetcode;

public class Code160_getIntersectionNode {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        
        ListNode cur = headA;
        int len = 0;
        while (cur != null) {
        	len++;
        	cur = cur.next;
        }
        cur = headB;
        while (cur != null) {
        	len--;
        	cur = cur.next;
        }
        
        ListNode longList = null;
        ListNode shortList = null;
        
        
        if (len-- >=0) {
        	longList = headA;
        	shortList = headB;
        } else {
        	longList = headB;
        	shortList = headA;
        }
        
        len = Math.abs(len);
        
        while(len > 0) { // 先把多的走了
        	longList = longList.next;
        }
        
        while(shortList !=null) {
        	if (longList == shortList) {
        		return shortList;
        	}
        	longList = longList.next;
        	shortList = shortList.next;
        }
        return null;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

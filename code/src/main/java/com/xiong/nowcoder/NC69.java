package com.xiong.nowcoder;

public class NC69 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public class Solution {
        public ListNode FindKthToTail(ListNode head, int k) {
            if (head == null) {
                return null;
            }
            ListNode fast = head;
            ListNode slow = head;

            int i = 0;

            while (fast != null && i < k) {
                fast = fast.next;
                i++;
            }
            if (fast == null && i < k) {
                return null;
            }
            while (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
    }
}

package com.xiong.nowcoder;

public class NC3 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public ListNode detectCycle(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode slow = head.next;
            ListNode fast = head;
            if (fast.next == null) {
                return null;
            }
            fast = head.next.next;

            ListNode meet = null;
            while (fast != null && fast.next != null) {
                if (fast == slow) {
                    meet = fast;
                    break;
                }
                slow = slow.next;
                fast = fast.next.next;
            }

            if (meet == null) {
                return null;
            }
            fast = head;
            while (fast!=slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        }
    }
}

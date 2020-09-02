package com.xiong.nowcoder;

public class NC78_reverse_2 {
    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    static class Solution {
        public ListNode ReverseList(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode first = head;
            ListNode pre = head;
            ListNode cur = head.next;
            ListNode curNext = null;
            if (cur != null) {
                curNext = cur.next;
            }
            while (cur != null) {
                cur.next = pre;
                pre = cur;
                cur = curNext;
                if (cur != null) {
                    curNext = cur.next;
                }
            }
            first.next = null;

            return pre;
        }
    }
}

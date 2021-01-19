package com.xiong.nowcoder;

public class NC25 {
    public class ListNode {
        int val;
        ListNode next = null;
    }

    public class Solution {
        /**
         * @param head ListNode类
         * @return ListNode类
         */
        public ListNode deleteDuplicates(ListNode head) {
            // write code here
            if (head == null) {
                return null;
            }
            ListNode pre = head;
            ListNode cur = head.next;

            while (cur != null) {
                if (cur.val == pre.val) {
                    pre.next = cur.next;
                } else {
                    pre = cur;
                }
                cur = cur.next;
            }
            return head;
        }
    }
}

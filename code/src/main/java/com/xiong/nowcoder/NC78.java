package com.xiong.nowcoder;

/**
 * https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca?tpId=188&&tqId=36164&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking
 */
public class NC78 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public class Solution {
        public ListNode ReverseList(ListNode head) {
            ListNode pre = null;
            ListNode cur = head;

            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }
    }
}

package com.xiong.nowcoder;

public class NC53 {

    public static class ListNode {
        int val;
        ListNode next = null;
    }

    public static class Solution {
        /**
         * @param head ListNode类
         * @param n    int整型
         * @return ListNode类
         */
        public ListNode removeNthFromEnd(ListNode head, int n) {
            // write code here
            if (head == null) {
                return null;
            }

            ListNode fast = head;
            ListNode slow = head;
            ListNode newHead = head;
            ListNode preNode = null;
            for (int i = 0; i < n - 1; i++) {
                fast = fast.next;
                if (fast == null) {
                    return head;
                }
            }
            while (fast.next != null) {
                fast = fast.next;
                preNode = slow;
                slow = slow.next;

            }
            if (preNode != null) {
                preNode.next = slow.next;
            } else {
                newHead = head.next;
            }
            return newHead;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = new ListNode();
        listNode.val = 1;
        ListNode listNode2 = new ListNode();
        listNode2.val = 2;
        listNode.next = listNode2;
        ListNode listNode1 = solution.removeNthFromEnd(listNode, 1);
        System.out.println(listNode1);
    }
}

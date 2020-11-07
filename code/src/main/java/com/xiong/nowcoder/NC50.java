package com.xiong.nowcoder;

/**
 * TODO: 这个题难度在于各种指针来回搞，思想不难，后续再处理吧，太费劲了
 */
public class NC50 {
      public class ListNode {
        int val;
        ListNode next = null;
      }

    /*
     * public class ListNode {
     *   int val;
     *   ListNode next = null;
     * }
     */

    public class Solution {
        /**
         *
         * @param head ListNode类
         * @param k int整型
         * @return ListNode类
         */
        public ListNode reverseKGroup (ListNode head, int k) {
            // write code here
            if (head == null || k <=1) {
                return head;
            }
            int reverseNum = 0;
            ListNode newHead = null;
            ListNode pre = null;
            ListNode begin = null;
            ListNode begin2 = head;
            while (head != null) {
                ListNode next = head.next;
                head.next = pre;
                if (reverseNum==0) {
                    head.next = null;
                }
                pre = head;
                head = next;
                reverseNum++;
                if (reverseNum == k) { // 到一组了
                    begin2.next = null;
                    if (newHead==null) {
                        newHead = pre;
                    }
                    if (begin!=null) {
                        begin.next = begin2;
                        begin = begin2;
                        begin2 = next;

                    }
                    reverseNum=0;
                }
            }
            head = pre;
            pre = null;
            if (reverseNum!=0) {
                while(head!=null) {
                    ListNode next = head.next;
                    head.next = pre;
                    pre = head;
                    head = next;
                }
                if (begin!= null) {
                    begin.next = pre;
                } else {
                    return pre;
                }

            }

            return newHead;
        }
    }

    public static void main(String[] args) {
        String[] arr = "172.16.254.1".split("\\.");
        System.out.println(1);
    }
}

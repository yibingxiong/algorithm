package com.xiong.nowcoder;

import java.util.ArrayList;
import java.util.LinkedList;

public class NC78_reverse {
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
            //始终指向链表的头结点
            ListNode pFirst = head;
            //三个结点中的第一个结点
            ListNode pPre = pFirst;
            //当前需要反转的结点
            ListNode pCur = head.next;
            //下一次即将需要反转的结点
            ListNode pFuture = null;
            while (pCur != null) {
                pFuture = pCur.next;
                pPre.next = pFuture;
                pCur.next = pFirst;
                pFirst = pCur;
                pCur = pFuture;
            }
            return pFirst;
        }
    }
}

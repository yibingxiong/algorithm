/*
 * @lc app=leetcode.cn id=21 lang=javascript
 *
 * [21] 合并两个有序链表
 */

/* 
可能的解法：
1. 移动指针，谁小动谁，串起来，直到有一个遍历完，将另一个
串到后边 时间O(m+n) 空间O(1)
2. 
*/
// @lc code=start
/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */


var mergeTwoLists = function (l1, l2) {
  if (l1 === null || l2 === null) {
    return l1 === null ? l2 : l1;
  }
  let head = null;
  let cur = null;
  while (l1 !== null && l2 !== null) {
    if (l1.val < l2.val) {
      if (head === null) {
        head = l1;
      }
      if (cur !== null) {
        cur.next = l1;
      }
      cur = l1;
      l1 = l1.next;
    } else {
      if (head === null) {
        head = l2;
      }
      if (cur !== null) {
        cur.next = l2;
      }
      cur = l2;
      l2 = l2.next;
    }
  }
  l1 === null ? cur.next = l2 : cur.next = l1;
  return head;
};
// @lc code=end


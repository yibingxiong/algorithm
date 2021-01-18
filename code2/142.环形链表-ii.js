/*
 * @lc app=leetcode.cn id=142 lang=javascript
 *
 * [142] 环形链表 II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/* 
可能的解法：
1. 快慢指针 时间O(n) 空间O(1)
2. set 时间O(n) 空间O(n)
*/
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
// 方法1
// var detectCycle = function (head) {
//   if (head === null || head.next === null) {
//     return null;
//   }

//   let slow = head;
//   let fast = head;
//   while (fast !== null && fast.next !== null) {
//     slow = slow.next;
//     fast = fast.next.next;
//     if (slow === fast) {
//       fast = head;
//       while (fast !== slow) {
//         slow = slow.next;
//         fast = fast.next;
//       }
//       return fast;
//     }
//   }
//   return null;
// };

// 方法2
var detectCycle = function (head) {
  if (head === null || head.next === null) {
    return null;
  }

  let set = new Set();
  while (head !== null) {
    if (set.has(head)) {
      return head;
    }
    set.add(head);
    head = head.next;
  }
  return null;
};
// @lc code=end


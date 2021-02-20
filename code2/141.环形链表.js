/*
 * @lc app=leetcode.cn id=141 lang=javascript
 *
 * [141] 环形链表
 */


/* 
可能的解法：
1. 直接遍历，往一个set(谢天谢地，js有set了)里仍，若已经存在了，有环
时间O(n) 空间O(n)
2. 快慢指针方法 时间O(n) 空间O(1)
*/

// @lc code=start
/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} head
 * @return {boolean}
 */
// 方法1
// var hasCycle = function (head) {
//   let set = new Set();
//   while (head != null) {
//     if (set.has(head)) {
//       return true;
//     }
//     set.add(head);
//     head = head.next;
//   }
//   return false;
// };

// 方法2
// var hasCycle = function (head) {
//   if (head === null || head.next === null) {
//     return false;
//   }

//   let slow = head;
//   let fast = head;

//   while (fast != null && fast.next != null) {
//     slow = slow.next;
//     fast = fast.next.next;
//     if (slow === fast) {
//       return true;
//     }
//   }
//   return false;
// };

// 第二遍

// 1 用set解决 时间O(n) 空间O(n)

// var hasCycle = function (head) {
//   if (head === null) return false;

//   const set = new Set();
//   while (head !== null) {
//     if (set.has(head)) {
//       return true;
//     }
//     set.add(head);
//     head = head.next;
//   }
//   return false;
// };

// 2 快慢指针

var hasCycle = function (head) {
  if (head === null || head.next === null) return false;

  let fast = head;
  let slow = head;

  while (fast != null && fast.next !== null) {
    slow = slow.next;
    fast = fast.next.next;
    if (slow === fast) {
      return true;
    }
  }
  return false;
};



// @lc code=end


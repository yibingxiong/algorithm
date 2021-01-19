/*
 * @lc app=leetcode.cn id=206 lang=javascript
 *
 * [206] 反转链表
 */

/**
 * 可能的解法：
 * 1. 直接放到栈里边，然后依次弹出并构建翻转链表
 * 时间O(n) 空间O(n)
 * 2. 通过直接操作指针来做 时间O(n) 空间O(1)
 * 3. 看题解有一种递归的解法，很骚气
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
 * @return {ListNode}
 */
// 方法1，操作指针
// var reverseList = function (head) {
//   if (head === null || head.next === null) {
//     return head;
//   }
//   let pre = null;
//   let cur = head;
//   while (cur !== null) {
//     let next = cur.next;
//     cur.next = pre;
//     pre = cur;
//     cur = next;
//   }
//   return pre;
// };

// 方法2，用栈
var reverseList = function (head) {
  if (head === null) {
    return head;
  }
  let stack = [];
  while (head !== null) {
    stack.push(head);
    head = head.next;
  }
  head = stack.pop();
  let cur = head;
  while (stack.length > 0) {
    cur.next = stack.pop();
    cur = cur.next;
  }
  cur.next = null; // 如果不加这一步，那么会成环
  return head;
};

// @lc code=end


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
// Definition for singly-linked list.
function ListNode(val, next) {
  this.val = (val === undefined ? 0 : val)
  this.next = (next === undefined ? null : next)
}

/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */

// 方法1
// var mergeTwoLists = function (l1, l2) {
//   if (l1 === null || l2 === null) {
//     return l1 === null ? l2 : l1;
//   }
//   let head = null;
//   let cur = null;
//   while (l1 !== null && l2 !== null) {
//     if (l1.val < l2.val) {
//       if (head === null) {
//         head = l1;
//       }
//       if (cur !== null) {
//         cur.next = l1;
//       }
//       cur = l1;
//       l1 = l1.next;
//     } else {
//       if (head === null) {
//         head = l2;
//       }
//       if (cur !== null) {
//         cur.next = l2;
//       }
//       cur = l2;
//       l2 = l2.next;
//     }
//   }
//   l1 === null ? cur.next = l2 : cur.next = l1;
//   return head;
// };

// 方法2 注意哑结点技巧
// var mergeTwoLists = function (l1, l2) {
//   if (l1 === null || l2 === null) {
//     return l1 === null ? l2 : l1;
//   }
//   let virtualNode = new ListNode(-1)
//   let cur = virtualNode;

//   while (l1 !== null && l2 !== null) {
//     if (l1.val < l2.val) {
//       cur.next = l1;
//       cur = l1;
//       l1 = l1.next;
//     } else {
//       cur.next = l2
//       cur = l2;
//       l2 = l2.next;
//     }
//   }
//   l1 === null ? cur.next = l2 : cur.next = l1;
//   return virtualNode.next;
// };

// 方法3 递归解法
var mergeTwoLists = function (l1, l2) {
  if (l1 === null) {
    return l2;
  }
  if (l2 === null) {
    return l1;
  }
  if (l1.val < l2.val) {
    l1.next = mergeTwoLists(l1.next, l2);
    return l1;
  } else {
    l2.next = mergeTwoLists(l1, l2.next);
    return l2;
  }
};
// @lc code=end


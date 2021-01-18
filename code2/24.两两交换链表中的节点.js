/*
 * @lc app=leetcode.cn id=24 lang=javascript
 *
 * [24] 两两交换链表中的节点
 */
/* 
可能的解法：
1. 两个两个读，放到一个n行2列的可变数组里边去，然后遍历数组，两两翻转
并连接， 时间O(n) 空间O(n)
2. 利用指针的指向调整实现时间O(n) 空间O(1)
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
 * @param {ListNode} head
 * @return {ListNode}
 */
// 方法1 用指针变换写好了，但是看起来不是很简洁的样子
// var swapPairs = function (head) {
//   if (head === null || head.next === null) {
//     return head;
//   }
//   let preGroupLast = null; // 是一组的最后一个节点
//   let curPre = null; // 当前节点的前一个节点
//   let count = 0; // 已经走了节点
//   let curNode = head;

//   while (curNode !== null) {
//     count++;
//     let next = curNode.next;
//     if (count % 2 === 0) {
//       curNode.next = curPre;
//       curPre.next = null;
//       if (preGroupLast === null) {
//         head = curNode;
//       } else {
//         preGroupLast.next = curNode;
//       }
//       preGroupLast = curPre;
//     } else {
//       curPre = curNode;
//     }
//     curNode = next;
//   }
//   if (count % 2 !== 0) {
//     preGroupLast.next = curPre;
//   }
//   return head;
// };
// 方法2 尝试一次走两步, 可读性大大提高了
// var swapPairs = function (head) {
//   if (head === null || head.next === null) {
//     return head;
//   }
//   let gNode1 = head;
//   let gNode2 = head.next;
//   let preGroupLast = null; // 上一个组的最后一个节点

//   while (gNode1 !== null && gNode2 !== null) {
//     let gNode2Next = gNode2.next;
//     gNode2.next = gNode1;
//     gNode1.next = null;
//     if (preGroupLast === null) {
//       head = gNode2;
//     } else {
//       preGroupLast.next = gNode2;
//     }
//     preGroupLast = gNode1;
//     // 为下一组准备
//     gNode1 = gNode2Next;
//     if (gNode1 !== null) {
//       gNode2 = gNode1.next;
//     } else {
//       gNode2 = null;
//     }
//   }
//   if (gNode1 != null && gNode2 === null) { // 基数个场景
//     preGroupLast.next = gNode1;
//   }
//   return head;
// };

// 方法3：两个两个取，往数组里丢，然后遍历数组哈哈
// var swapPairs = function (head) {
//   if (head === null || head.next === null) {
//     return head;
//   }
//   let gNode1 = head;
//   let gNode2 = head.next;
//   let tmp = [];

//   while (gNode1 !== null && gNode2 !== null) {
//     let gNode2Next = gNode2.next;
//     gNode1.next = null;
//     gNode2.next = gNode1;
//     tmp.push({
//       a: gNode2,
//       b: gNode1
//     })
//     // 为下一组准备
//     gNode1 = gNode2Next;
//     if (gNode1 !== null) {
//       gNode2 = gNode1.next;
//     } else {
//       gNode2 = null;
//     }
//   }

//   if (gNode1 != null && gNode2 === null) { // 基数个场景
//     tmp.push({
//       a: gNode1,
//       b: null,
//     })
//   }

//   for (let i = 0; i < tmp.length - 1; i++) {
//     tmp[i].b.next = tmp[i + 1].a;
//   }

//   return tmp[0].a;
// };

// 方法4：来自题解，跟2差不多
// var swapPairs = function (head) {
//   if (head === null || head.next === null) {
//     return head;
//   }
//   let last = null;
//   let newHead = null;
//   while (head !== null && head.next !== null) {
//     let first = head;
//     let second = head.next;

//     let secondNext = second.next;
//     second.next = first;
//     first.next = null;
//     if (last !== null) {
//       last.next = second;
//     } else {
//       newHead = second;
//     }
//     last = first;
//     head = secondNext;
//   }
//   if (head !== null && head.next === null) {
//     last.next = head;
//   }
//   return newHead;
// };

// 方法5：递归的写法
var swapPairs = function (head) {
  if (head === null || head.next === null) {
    return head;
  }
  let newHead = head.next;
  head.next = swapPairs(newHead.next);
  newHead.next = head;
  return newHead;
};
// @lc code=end


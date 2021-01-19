/*
 * @lc app=leetcode.cn id=25 lang=javascript
 *
 * [25] K 个一组翻转链表
 */

// @lc code=start

// Definition for singly-linked list.
function ListNode(val, next) {
  this.val = (val === undefined ? 0 : val)
  this.next = (next === undefined ? null : next)
}


/* 
可能的解法：
1. 遍历用二维数组存，k个一样，最后遍历这个二维数组，连起来
2. k个k个的读，k个k个的转，需要重点考虑边界情况
*/
/**
 * @param {ListNode} head
 * @param {number} k
 * @return {ListNode}
 */
// 方法1 写法方面还需要完善
var reverseKGroup = function (head, k) {
  if (head === null || head.next === null) {
    return head;
  }
  let preGroupLast = null;
  let cur = head;

  while (cur !== null) {
    let c = 1;
    let start = cur;
    let innerCur = cur;
    while (c < k) {
      innerCur = innerCur.next;
      if (innerCur !== null) {
        c++;
      } else {
        break;
      }
    }
    // 此时innerCur为最后的一个节点
    let bigLoopNext = null;
    let end = innerCur;
    if (c === k) { // 够k个，需要翻转
      bigLoopNext = innerCur.next;
      innerCur = start;
      let pre = null;
      c = 0;
      while (c < k) {
        c++;
        let next = innerCur.next;
        innerCur.next = pre;
        pre = innerCur;
        innerCur = next;
      }
      start.next = null;
    } else {
      if (preGroupLast !== null) {
        preGroupLast.next = start;
        break;
      } else {
        head = start;
        break;
      }
    }
    if (preGroupLast === null) {
      head = end;
    } else if (c === k) {
      preGroupLast.next = end;
    } else {
      preGroupLast.next = start;
    }
    preGroupLast = start;
    cur = bigLoopNext;
  }
  return head;
};
// @lc code=end

/// test

// let head = new ListNode(1, null);
// head.next = new ListNode(2, null)
// head.next.next = new ListNode(3, null);
// head.next.next.next = new ListNode(4, null);
// head.next.next.next.next = new ListNode(5, null)

// let a = reverseKGroup(head, 2);

// while(a!=null) {
//   console.log(a.val);
//   a= a.next;
// }
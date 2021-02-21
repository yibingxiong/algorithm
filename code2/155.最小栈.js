/*
 * @lc app=leetcode.cn id=155 lang=javascript
 *
 * [155] 最小栈
 */

// @lc code=start

// 第1遍

// 1
// /**
//  * initialize your data structure here.
//  */
// var MinStack = function () {
//   this.stack1 = [];
//   this.stack2 = [];
// };

// /** 
//  * @param {number} x
//  * @return {void}
//  */
// MinStack.prototype.push = function (x) {
//   this.stack1.push(x);
//   if (this.stack2.length === 0 || this.stack2[this.stack2.length - 1] >= x) {
//     this.stack2.push(x);
//   }
// };

// /**
//  * @return {void}
//  */
// MinStack.prototype.pop = function () {
//   const res = this.stack1.pop();
//   if (res === this.stack2[this.stack2.length - 1]) {
//     this.stack2.pop();
//   }
//   return res;
// };

// /**
//  * @return {number}
//  */
// MinStack.prototype.top = function () {
//   return this.stack1[this.stack1.length - 1]
// };

// /**
//  * @return {number}
//  */
// MinStack.prototype.getMin = function () {
//   return this.stack2[this.stack2.length - 1]
// };

// 2

class Node {
  constructor(val, min, next) {
    this.val  = val;
    this.min  = min;
    this.next = next;
  }
}

/**
 * initialize your data structure here.
 */
var MinStack = function () {
  this.head = null;
};

/** 
 * @param {number} x
 * @return {void}
 */
MinStack.prototype.push = function (x) {
  if (this.head == null) {
    this.head = new Node(x, x, null);
  } else {
    this.head = new Node(x, Math.min(x, this.head.min), this.head);
  }
};

/**
 * @return {void}
 */
MinStack.prototype.pop = function () {
  let v = this.head.val;
  this.head = this.head.next;
  return v;
};

/**
 * @return {number}
 */
MinStack.prototype.top = function () {
  return this.head.val;
};

/**
 * @return {number}
 */
MinStack.prototype.getMin = function () {
  return this.head.min;
};

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = new MinStack()
 * obj.push(x)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */
// @lc code=end


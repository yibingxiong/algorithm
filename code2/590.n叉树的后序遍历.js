/*
 * @lc app=leetcode.cn id=590 lang=javascript
 *
 * [590] N叉树的后序遍历
 */

// @lc code=start
/**
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */

// 1
// /**
//  * @param {Node} root
//  * @return {number[]}
//  */
// var postorder = function (root) {
//   const res = [];
//   function post(root) {
//     if (root === null) {
//       return;
//     }
//     const children = root.children;
//     for (let child of children) {
//       post(child);
//     }
//     res.push(root.val);
//   }
//   post(root);
//   return res;
// };

// 2

/**
 * @param {Node} root
 * @return {number[]}
 */
var postorder = function (root) {
  const res = [];
  const stack = [];
  if (root === null) {
    return res;
  }
  stack.push(root);
  while (stack.length) {
    root = stack.pop();
    res.unshift(root.val);
    if (root.children) {
      for (let child of root.children) {
        stack.push(child);
      }
    }
  }
  return res;
}
// @lc code=end


/*
 * @lc app=leetcode.cn id=429 lang=javascript
 *
 * [429] N 叉树的层序遍历
 */

// @lc code=start
/**
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */
// 第1遍

// 1
// /**
//  * @param {Node} root
//  * @return {number[][]}
//  */
// var levelOrder = function (root) {
//   const res = [];
//   if (root === null) {
//     return res;
//   }
//   let previousLayer = [root];
//   while (previousLayer.length) {
//     let currentLayer = [];
//     const previousVals = [];
//     for (let child of previousLayer) {
//       previousVals.push(child.val);
//       if (child.children) {
//         currentLayer.push(...child.children);
//       } else {
//         currentLayer = [];
//       }
//     }
//     res.push(previousVals);
//     previousLayer = currentLayer;
//   }
//   return res;
// };

/**
 * @param {Node} root
 * @return {number[][]}
 */
var levelOrder = function (root) {
  const res = [];
  if (root === null) {
    return res;
  }
  const queue = [root];

  while (queue.length) {
    let len = queue.length;
    let level = [];
    for (let i = 0; i < len; i++) {
      root = queue.shift();
      level.push(root.val);
      if (root.children) {
        queue.push(...root.children)
      }
    }
    res.push(level)
  }

  return res;
};
// @lc code=end


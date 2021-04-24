/*
 * @lc app=leetcode.cn id=104 lang=javascript
 *
 * [104] 二叉树的最大深度
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */

// 第1遍
// 1
// /**
//  * @param {TreeNode} root
//  * @return {number}
//  */
// var maxDepth = function (root) {
//   if (root === null) {
//     return 0;
//   }
//   return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
// };

// 2
/**
 * @param {TreeNode} root
 * @return {number}
 */
// var maxDepth = function (root) {
//   if (root === null) {
//     return 0;
//   }

//   const queue = [root];
//   let level = 0;
//   while (queue.length) {
//     const len = queue.length;
//     for (let i = 0; i < len; i++) {
//       const a = queue.shift();
//       if (a.left) {
//         queue.push(a.left)
//       }
//       if (a.right) {
//         queue.push(a.right);
//       }
//     }
//     level++;
//   }
//   return level;
// };

// 3
// var maxDepth = function (root) {
//   if (root === null) return 0;
//   return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
// };

// 4
// var maxDepth = function (root) {
//   const queue = [];
//   if (root === null) return 0;
//   queue.push(root);
//   let level = 0;
//   while (queue.length) {
//     let len = queue.length;
//     level++;
//     for (let i = 0; i < len; i++) {
//       const node = queue.shift();
//       if (node.left) {
//         queue.push(node.left);
//       }
//       if (node.right) {
//         queue.push(node.right);
//       }
//     }
//   }
//   return level;
// }

// var maxDepth = function (root) {
//   if (root === null) return 0;
//   return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
// }

var maxDepth = function (root) {
  if (root === null) return 0;
  const queue = [root];
  let level = 0;
  while(queue.length) {
    let len = queue.length;
    for(let i = 0; i < len; i++) {
      const node = queue.shift();
      if (node.left) {
        queue.push(node.left);
      }
      
      if (node.right) {
        queue.push(node.right);
      }
    }
    level++;
  }
  return level;
}
// @lc code=end


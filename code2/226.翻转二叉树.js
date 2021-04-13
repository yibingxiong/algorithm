/*
 * @lc app=leetcode.cn id=226 lang=javascript
 *
 * [226] 翻转二叉树
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
//  * @return {TreeNode}
//  */
// var invertTree = function (root) {
//     function invert(root) {
//         if (root === null) {
//             return null;
//         }
//         const left = invert(root.right);
//         const right = invert(root.left);
//         root.left = left;
//         root.right = right;

//         return root;
//     }

//     return invert(root);
// };

// 2
/**
 * @param {TreeNode} root
 * @return {TreeNode}
 */
// var invertTree = function (root) {
//   const queue = [];
//   if (root === null) {
//     return root;
//   }

//   queue.push(root);

//   while (queue.length) {
//     const node = queue.shift();
//     const t = node.left;
//     node.left = node.right;
//     node.right = t;

//     if (node.left !== null) {
//       queue.push(node.left);
//     }
//     if (node.right !== null) {
//       queue.push(node.right);
//     }
//   }
//   return root;
// };

// 3
// /**
//  * @param {TreeNode} root
//  * @return {TreeNode}
//  */
//  var invertTree = function (root) {
//   if (root === null) {
//     return null;
//   }
//   const tmp = root.left;
//   root.left = invertTree(root.right);
//   root.right = invertTree(tmp);
//   return root;
// };

// 4
/**
 * @param {TreeNode} root
 * @return {TreeNode}
 */
var invertTree = function (root) {
  const queue = [];
  if (root === null) return root;
  queue.push(root);
  while (queue.length) {
    const node = queue.shift();
    const t = node.left;
    node.left = node.right;
    node.right = t;
    if (node.left) {
      queue.push(node.left);
    }
    if (node.right) {
      queue.push(node.right);
    }

  }
  return root;
};
// @lc code=end


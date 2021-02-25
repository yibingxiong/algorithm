/*
 * @lc app=leetcode.cn id=111 lang=javascript
 *
 * [111] 二叉树的最小深度
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
// /**
//  * @param {TreeNode} root
//  * @return {number}
//  */
// var minDepth = function (root) {
//     if (root === null) {
//         return 0;
//     }
//     const queue = [root];
//     let level = 0;
//     while (queue.length) {
//         let len = queue.length;
//         while (len > 0) {
//             const node = queue.shift();
//             if (node.left === null && node.right === null) {
//                 return level + 1;
//             }
//             if (node.left !== null) {
//                 queue.push(node.left);
//             }
//             if (node.right !== null) {
//                 queue.push(node.right);
//             }
//             len--;
//         }
//         level++;
//     }
//     return level;
// };

/**
 * @param {TreeNode} root
 * @return {number}
 */
var minDepth = function (root) {
    if (root === null) {
        return 0;
    }
    let l = minDepth(root.left);
    let r = minDepth(root.right);
    return (l === 0 || r === 0) ? r + l + 1 : Math.min(l, r) + 1;
};
// @lc code=end


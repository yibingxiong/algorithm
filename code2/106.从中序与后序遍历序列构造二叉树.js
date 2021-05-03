/*
 * @lc app=leetcode.cn id=106 lang=javascript
 *
 * [106] 从中序与后序遍历序列构造二叉树
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
/**
 * @param {number[]} inorder
 * @param {number[]} postorder
 * @return {TreeNode}
 */
var buildTree = function (inorder, postorder) {
  const map = new Map();
  for (let i = 0; i < inorder.length; i++) {
    map.set(inorder[i], i);
  }
  function build(postLeft, postRight, inLeft, inRight) {
    if (postLeft > postRight || inLeft > inRight) return null;
    const rV = postorder[postRight];
    const root = new TreeNode(rV);
    const newInIdx = map.get(rV);
    root.left = build(postLeft, newInIdx - inLeft + postLeft - 1, inLeft, newInIdx - 1);
    root.right = build(newInIdx - inLeft + postLeft, postRight - 1, newInIdx + 1, inRight);
    return root;
  }
  return build(0, postorder.length - 1, 0, inorder.length - 1);
};
// @lc code=end


/*
 * @lc app=leetcode.cn id=589 lang=javascript
 *
 * [589] N叉树的前序遍历
 */

// @lc code=start
/**
 * // Definition for a Node.
 * function Node(val, children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */

/**
 * @param {Node} root
 * @return {number[]}
 */
var preorder = function (root) {
  const stack = [];
  const res = [];
  if (root === null) {
    return res;
  }
  stack.push(root);
  while (stack.length) {
    root = stack.pop();
    res.push(root.val);
    const childrenRreverse = root.children.reverse()
    for (let child of childrenRreverse) {
      stack.push(child);
    }
  }
  return res;
};
// @lc code=end


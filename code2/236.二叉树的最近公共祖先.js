/*
 * @lc app=leetcode.cn id=236 lang=javascript
 *
 * [236] 二叉树的最近公共祖先
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */

// 第1遍 

// 1
// /**
//  * @param {TreeNode} root
//  * @param {TreeNode} p
//  * @param {TreeNode} q
//  * @return {TreeNode}
//  */
// var lowestCommonAncestor = function (root, p, q) {
//   let ans = null;
//   function dfs(root) {
//     if (root === null) {
//       return false;
//     }
//     const l = dfs(root.left);
//     const r = dfs(root.right);

//     if ((l && r) || ((l || r) && (root === p || root === q))) {
//       ans = root;
//     }
//     return (l || r) || (root === q || root === p);
//   }
//   dfs(root);
//   return ans;
// };

// 2
/**
 * @param {TreeNode} root
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {TreeNode}
 */
var lowestCommonAncestor = function (root, p, q) {
  if (root == null) {
    return false;
  }
  const pMap = new Map();
  function dfs(root) {
    if (root.left !== null) {
      pMap.set(root.left, root);
      dfs(root.left);
    }
    if (root.right !== null) {
      pMap.set(root.right, root);
      dfs(root.right);
    }
  }
  dfs(root);
  const set = new Set();
  while (p) {
    set.add(p);
    p = pMap.get(p);
  }
  while (q) {
    if (set.has(q)) {
      return q;
    }
    q = pMap.get(q);
  }
  return null;
};
// @lc code=end


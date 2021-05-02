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
// /**
//  * @param {TreeNode} root
//  * @param {TreeNode} p
//  * @param {TreeNode} q
//  * @return {TreeNode}
//  */
// var lowestCommonAncestor = function (root, p, q) {
//   if (root == null) {
//     return false;
//   }
//   const pMap = new Map();
//   function dfs(root) {
//     if (root.left !== null) {
//       pMap.set(root.left, root);
//       dfs(root.left);
//     }
//     if (root.right !== null) {
//       pMap.set(root.right, root);
//       dfs(root.right);
//     }
//   }
//   dfs(root);
//   const set = new Set();
//   while (p) {
//     set.add(p);
//     p = pMap.get(p);
//   }
//   while (q) {
//     if (set.has(q)) {
//       return q;
//     }
//     q = pMap.get(q);
//   }
//   return null;
// };


// // 3 先把每个节点的父亲找到，从p开始往他的父亲找，形成一个集合A
// // 然后从q往上找，如果在集合A中，则找到了
// /**
//  * @param {TreeNode} root
//  * @param {TreeNode} p
//  * @param {TreeNode} q
//  * @return {TreeNode}
//  */
// var lowestCommonAncestor = function (root, p, q) {
//   // 构建parentMap
//   const parentMap = new Map();
//   function buildParentMap(root) {
//     if (root === null) return;
//     if (root.left) {
//       parentMap.set(root.left, root);
//       buildParentMap(root.left);
//     }
//     if (root.right) {
//       parentMap.set(root.right, root);
//       buildParentMap(root.right);
//     }
//   }
//   buildParentMap(root);

//   const pParents = new Set();

//   while (p) {
//     pParents.add(p);
//     p = parentMap.get(p);
//   }
//   while (q) {
//     if (pParents.has(q)) {
//       return q;
//     }
//     q = parentMap.get(q);
//   }
//   return null;
// };


// 3 采用深度优先遍历，
/**
 * @param {TreeNode} root
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {TreeNode}
 */
var lowestCommonAncestor = function (root, p, q) {
  if (!root) return null;
  let ans = null;
  function dfs(root) {
    if (root === null) return false;
    const l = dfs(root.left);
    const r = dfs(root.right);
    if ((l && r) || (l || r) && (root === q || root === p)) {
      ans = root;
    }
    return (l || r) || (root === q || root === p);
  }
  dfs(root);
  return ans;
};
// @lc code=end


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
/**
 * @param {TreeNode} root
 * @return {TreeNode}
 */
var invertTree = function (root) {
    function invert(root) {
        if (root === null) {
            return null;
        }
        const left = invert(root.right);
        const right = invert(root.left);
        root.left = left;
        root.right = right;
        
        return root;
    }

    return invert(root);
};
// @lc code=end


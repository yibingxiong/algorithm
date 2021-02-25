/*
 * @lc app=leetcode.cn id=98 lang=javascript
 *
 * [98] 验证二叉搜索树
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
 * @return {boolean}
 */
var isValidBST = function (root) {
    function isValid(root) {
        if (root === null) {
            return {
                isValid: true,
                max: Number.MIN_SAFE_INTEGER,
                min: Number.MAX_SAFE_INTEGER,
            }
        }
        const l = isValid(root.left);
        const r = isValid(root.right);
        const min = Math.min(l.min, root.val, r.min);
        const max = Math.max(l.max, root.val, r.max);
        let v = l.isValid && r.isValid;
        if (root.left) {
            v = v && l.max < root.val;
        }
        if (root.right) {
            v = v && r.min > root.val;
        }
        return {
            isValid: v,
            max,
            min,
        }
    }
    return isValid(root).isValid;
};
// @lc code=end


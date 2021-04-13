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

// 第1遍

// 1
// /**
//  * @param {TreeNode} root
//  * @return {boolean}
//  */
// var isValidBST = function (root) {
//     function isValid(root) {
//         if (root === null) {
//             return {
//                 isValid: true,
//                 max: Number.MIN_SAFE_INTEGER,
//                 min: Number.MAX_SAFE_INTEGER,
//             }
//         }
//         const l = isValid(root.left);
//         const r = isValid(root.right);
//         const min = Math.min(l.min, root.val, r.min);
//         const max = Math.max(l.max, root.val, r.max);
//         let v = l.isValid && r.isValid;
//         if (root.left) {
//             v = v && l.max < root.val;
//         }
//         if (root.right) {
//             v = v && r.min > root.val;
//         }
//         return {
//             isValid: v,
//             max,
//             min,
//         }
//     }
//     return isValid(root).isValid;
// };

// 2
// /**
//  * @param {TreeNode} root
//  * @return {boolean}
//  */
// var isValidBST = function (root) {
//     if (root === null) {
//         return true;
//     }
//     const stack = [];
//     let last = Number.MIN_SAFE_INTEGER;
//     while (stack.length || root) {
//         while (root) {
//             stack.push(root);
//             root = root.left;
//         }
//         const l = stack.pop();
//         if (l.val <= last) {
//             return false;
//         }
//         last = l.val;
//         root = l.right;
//     }
//     return true;
// };

// 3
// /**
//  * @param {TreeNode} root
//  * @return {boolean}
//  */
// var isValidBST = function (root) {
//     if (root === null) {
//         return true;
//     }
//     let last = Number.MIN_SAFE_INTEGER;
//     let res = true;
//     function isValid(root) {
//         if (root === null) {
//             return;
//         }
//         isValid(root.left);
//         if (root.val <= last) {
//             res = false;
//         }
//         last = root.val;
//         isValid(root.right);
//     }
//     isValid(root);

//     return res;
// };

// 4
// /**
//  * @param {TreeNode} root
//  * @return {boolean}
//  */
// var isValidBST = function (root) {
//     let isBST = true;
//     let v = Number.MIN_SAFE_INTEGER;

//     function preOrder(root) {
//         if (root === null) return;
//         preOrder(root.left);
//         if (root.val <= v) {
//             isBST = false;
//             return;
//         }
//         v = root.val;
//         preOrder(root.right);
//     }

//     preOrder(root);
//     return isBST;
// };

// 5
/**
 * @param {TreeNode} root
 * @return {boolean}
 */
var isValidBST = function (root) {
    const stack = [];
    let last = Number.MIN_SAFE_INTEGER;
    while (stack.length || root) {
        while (root) {
            stack.push(root);
            root = root.left;
        }
        const node = stack.pop();
        if (node.val <= last) {
            return false;
        }
        last = node.val;
        root = node.right;
    }

    return true;
};
// @lc code=end


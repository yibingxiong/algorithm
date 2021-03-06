/*
 * @lc app=leetcode.cn id=105 lang=javascript
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
//  * @param {number[]} preorder
//  * @param {number[]} inorder
//  * @return {TreeNode}
//  */
// var buildTree = function (preorder, inorder) {
//     const map = {};
//     for (let i = 0; i < inorder.length; i++) {
//         map[inorder[i]] = i;
//     }

//     function build(preorder, inorder, preLeft, preRight, inLeft, inRight) {
//         if (preRight < preLeft || inRight < inLeft) {
//             return null;
//         }
//         const rootV = preorder[preLeft];
//         const rootNode = new TreeNode(rootV);
//         const inPov = map[rootV];

//         rootNode.left = build(preorder, inorder, preLeft + 1, inPov - inLeft + preLeft, inLeft, inPov - 1);
//         rootNode.right = build(preorder, inorder, inPov - inLeft + preLeft + 1, preRight, inPov + 1, inRight);
//         return rootNode;
//     }

//     return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
// };

// 2
/**
 * @param {number[]} preorder
 * @param {number[]} inorder
 * @return {TreeNode}
 */
var buildTree = function (preorder, inorder) {
    const map = new Map();
    for (let i = 0; i < inorder.length; i++) {
        map.set(inorder[i], i);
    }
    function build(preLeft, preRight, inLeft, inRight) {
        if (preLeft > preRight || inLeft > inRight) return null;
        const rV = preorder[preLeft];
        const root = new TreeNode(rV);
        const newInIdx = map.get(rV);
        root.left = build(preLeft + 1, newInIdx - inLeft + preLeft, inLeft, newInIdx - 1,);
        root.right = build(newInIdx - inLeft + preLeft + 1, preRight, newInIdx + 1, inRight);
        return root;
    }
    return build(0, preorder.length - 1, 0, inorder.length - 1);
};
// @lc code=end


/*
 * @lc app=leetcode.cn id=297 lang=javascript
 *
 * [297] 二叉树的序列化与反序列化
 */

// @lc code=start

function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}



// /**
//  * Encodes a tree to a single string.
//  *
//  * @param {TreeNode} root
//  * @return {string}
//  */
// var serialize = function (root) {
//   if (root === null) {
//     return '#,';
//   }
//   let res = '';
//   function se(root) {
//     if (root === null) {
//       res += '#,';
//       return;
//     }
//     res += `${root.val},`
//     se(root.left);
//     se(root.right);
//   }
//   se(root);
//   return res;
// };

// /**
//  * Decodes your encoded data to tree.
//  *
//  * @param {string} data
//  * @return {TreeNode}
//  */
// var deserialize = function (data) {
//   const arr = data.split(',');
//   function de(arr) {
//     const a = arr.shift();
//     if (a === '#') {
//       return null;
//     }
//     const root = new TreeNode(a);
//     root.left = de(arr);
//     root.right = de(arr);
//     return root;
//   }
//   return de(arr);
// };

// 第二次做
/**
 * Encodes a tree to a single string.
 *
 * @param {TreeNode} root
 * @return {string}
 */
var serialize = function (root) {
  function se(root, res) {
    if (root === null) {
      res = '#,';
    } else {
      res += `${root.val},`
      res += serialize(root.left, res);
      res += serialize(root.right, res);
    }
    return res;
  }
  return se(root, '')
};

/**
 * Decodes your encoded data to tree.
 *
 * @param {string} data
 * @return {TreeNode}
 */
var deserialize = function (data) {
  const arr = data.split(',');
  function de(arr) {
    const a = arr.shift();
    if (a === '#') {
      return null;
    }
    const root = new TreeNode(a);
    root.left = de(arr);
    root.right = de(arr);
    return root;
  }
  return de(arr);
};
/**
 * Your functions will be called as such:
 * deserialize(serialize(root));
 */
// @lc code=end
// const root = new TreeNode(1);


// const a = serialize(root)
// console.log(a)
// const b = deserialize(a);
// console.log(b.val);

/*
 * @lc app=leetcode.cn id=22 lang=javascript
 *
 * [22] 括号生成
 */

// @lc code=start

// 第1遍

// 1
// /**
//  * @param {number} n
//  * @return {string[]}
//  */
// var generateParenthesis = function (n) {
//   const res = [];
//   function gen(str, lCount, rCount) {
//     if (lCount === n && rCount === n) {
//       res.push(str);
//       return;
//     }
//     if (lCount < n) {
//       gen(str + '(', lCount + 1, rCount);
//     }
//     if (rCount < lCount) {
//       gen(str + ')', lCount, rCount + 1);
//     }
//   }
//   gen('', 0, 0);
//   return res;
// };

// 2
/**
 * @param {number} n
 * @return {string[]}
 */
var generateParenthesis = function (n) {
  const res = [];
  function gen(str, r, l) {
    if (r === 0 && l === 0) {
      res.push(str);
      return;
    }
    if (l > 0) {
      gen(str + '(', r + 1, l - 1);
    }
    if (r > 0) {
      gen(str + ')', r - 1, l);
    }
  }
  gen('', 0, n);
  return res;
};
// @lc code=end


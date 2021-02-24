/*
 * @lc app=leetcode.cn id=22 lang=javascript
 *
 * [22] 括号生成
 */

// @lc code=start
/**
 * @param {number} n
 * @return {string[]}
 */
var generateParenthesis = function (n) {
  const res = [];
  function gen(str, lCount, rCount) {
    if (lCount === n && rCount === n) {
      res.push(str);
      return;
    }
    if (lCount < n) {
      gen(str + '(', lCount + 1, rCount);
    }
    if (rCount < lCount) {
      gen(str + ')', lCount, rCount + 1);
    }
  }
  gen('', 0, 0);
  return res;
};
// @lc code=end


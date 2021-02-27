/*
 * @lc app=leetcode.cn id=77 lang=javascript
 *
 * [77] 组合
 */

// @lc code=start
/**
 * @param {number} n
 * @param {number} k
 * @return {number[][]}
 */
var combine = function (n, k) {
  const res = [];
  function dfs(cur, temp) {
    if (temp.length === k) {
      res.push(temp.concat());
      return;
    }
    if (temp.length + (n - cur + 1) < k) {
      return;
    }
    dfs(cur + 1, temp);
    temp.push(cur);
    dfs(cur + 1, temp);
    temp.pop();
  }
  dfs(1, []);
  return res;
};
// @lc code=end


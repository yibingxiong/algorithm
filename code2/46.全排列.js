/*
 * @lc app=leetcode.cn id=46 lang=javascript
 *
 * [46] 全排列
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function(nums) {
  const res = [];
  const len = nums.length;
  if (nums.length === 0) {
    return res;
  }
  function dfs (path, used) {
    if (path.length === len) {
      res.push(path.concat());
      return;
    }
    for(let i = 0; i < len; i++) {
      if (used[i]) {
        continue;
      }
      path.push(nums[i]);
      used[i] = true;
      dfs(path, used);
      used[i] = false;
      path.pop();
    }
  }
  dfs([], []);
  return res;
};
// @lc code=end


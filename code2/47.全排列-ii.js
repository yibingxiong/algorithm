/*
 * @lc app=leetcode.cn id=47 lang=javascript
 *
 * [47] 全排列 II
 */

// @lc code=start
// /**
//  * @param {number[]} nums
//  * @return {number[][]}
//  */
// var permuteUnique = function (nums) {
//   const res = [];
//   const len = nums.length;
//   if (nums.length === 0) {
//     return res;
//   }
//   function dfs(path, used) {
//     if (path.length === len) {
//       res.push(path.concat());
//       return;
//     }
//     for (let i = 0; i < len; i++) {
//       if (used[i] || (i > 0 && nums[i] === nums[i - 1]) && !used[i - 1]) {
//         continue;
//       }
//       path.push(nums[i]);
//       used[i] = true;
//       dfs(path, used);
//       used[i] = false;
//       path.pop();
//     }
//   }
//   nums.sort((a, b) => a - b)
//   dfs([], []);
//   return res;
// };

// 2
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permuteUnique = function (nums) {
  const res = [];

  function dfs(tmp = [], used = []) {
    if (tmp.length === nums.length) {
      res.push(tmp.concat());
      return;
    }
    for (let i = 0; i < nums.length; i++) {
      if (used[i]) continue;
      if (i > 0 && nums[i] === nums[i-1] && !used[i-1]) continue;
      tmp.push(nums[i]);
      used[i] = true;
      dfs(tmp, used);
      tmp.pop();
      used[i] = false;
    }
  }
  nums.sort((a, b) => a - b);
  dfs();
  return res;
};
// @lc code=end


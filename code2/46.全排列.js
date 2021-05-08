/*
 * @lc app=leetcode.cn id=46 lang=javascript
 *
 * [46] 全排列
 */

// @lc code=start
// /**
//  * @param {number[]} nums
//  * @return {number[][]}
//  */
// var permute = function(nums) {
//   const res = [];
//   const len = nums.length;
//   if (nums.length === 0) {
//     return res;
//   }
//   function dfs (path, used) {
//     if (path.length === len) {
//       res.push(path.concat());
//       return;
//     }
//     for(let i = 0; i < len; i++) {
//       if (used[i]) {
//         continue;
//       }
//       path.push(nums[i]);
//       used[i] = true;
//       dfs(path, used);
//       used[i] = false;
//       path.pop();
//     }
//   }
//   dfs([], []);
//   return res;
// };

// 2
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function (nums) {
  const res = [];
  function dfs(tmp = [], used = []) {
    for (let i = 0; i < nums.length; i++) {
      if (used[i]) continue;
      tmp.push(nums[i]);
      used[i] = true;
      dfs(tmp, used);
      tmp.pop();
      used[i] = false;
    }
    if (tmp.length === nums.length) {
      res.push(tmp.concat());
      return;
    }
  }
  dfs();
  return res;
};
// @lc code=end


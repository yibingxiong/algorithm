/*
 * @lc app=leetcode.cn id=78 lang=javascript
 *
 * [78] 子集
 */

// @lc code=start

// 第1遍

// 1
// /**
//  * @param {number[]} nums
//  * @return {number[][]}
//  */
// var subsets = function (nums) {
//   const len = nums.length;
//   const res = [];
//   function dfs(path, pos) {
//     if (pos === len) {
//       res.push(path.concat())
//       return;
//     }
//     dfs(path, pos + 1);
//     path.push(nums[pos]);
//     dfs(path, pos + 1);
//     path.pop();
//   }
//   dfs([], 0);
//   return res;
// };

// // 2
// /**
//  * @param {number[]} nums
//  * @return {number[][]}
//  */
// var subsets = function (nums) {
//   const res = [[]];
//   for (const num of nums) {
//     const subset = [];
//     for (const r of res) {
//       subset.push([...r, num])
//     }
//     res.push(...subset)
//   }
//   return res;
// };

// 3
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsets = function (nums) {
  const res = [];
  function dfs(pos = 0, tmp = []) {
    if (pos === nums.length) {
      res.push(tmp.concat());
      return;
    }
    tmp.push(nums[pos++]);
    dfs(pos, tmp);
    tmp.pop();
    dfs(pos, tmp);
  }
  dfs();
  return res;
};
// @lc code=end


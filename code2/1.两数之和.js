/*
 * @lc app=leetcode.cn id=1 lang=javascript
 *
 * [1] 两数之和
 */

/* 
1. 建立map，然后找
2. 先排序，然后找, 要返回下标，这样还不行
3. 暴力解 O(n^2)
*/
// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
// 方法1
// var twoSum = function (nums, target) {
//   for (let i = 0; i < nums.length - 1; i++) {
//     for (let j = i + 1; j < nums.length; j++) {
//       if (nums[i] + nums[j] === target) {
//         return [i, j];
//       }
//     }
//   }
//   return null;
// };

// var twoSum = function (nums, target) {
//   let map = {};
//   for (let i = 0; i < nums.length; i++) {
//     let k = map[target - nums[i]]
//     if (typeof map[target - nums[i]] === 'undefined') {
//       map[nums[i]] = i;
//     } else {
//       return [i, k]
//     }
//   }
//   return null;
// };

// 第2遍

var twoSum = function (nums, target) {
  const map = {};
  for (let i = 0; i < nums.length; i++) {
    if (map[target - nums[i]] != undefined) {
      return [i, map[target - nums[i]]]
    } else {
      map[nums[i]] = i;
    }
  }
  return null;
};
// @lc code=end


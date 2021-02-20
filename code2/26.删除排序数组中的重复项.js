/*
 * @lc app=leetcode.cn id=26 lang=javascript
 *
 * [26] 删除排序数组中的重复项
 */

/* 
可能的解法：
1. 双指针：时间复杂度O(n)
2. 暴力删，可能在js里边用到的是拷贝时间复杂度O(n^2)
*/
// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */

// function swap(nums, i, j) {
//   let t = nums[i];
//   nums[i] = nums[j];
//   nums[j] = t;
// }
// var removeDuplicates = function (nums) {
//   if (nums.length === 1) {
//     return 1;
//   }
//   for (let i = 1; i < nums.length;) {
//     if (nums[i] === nums[i - 1]) {
//       nums.splice(i, 1);
//     } else {
//       i++;
//     }
//   }
//   return nums.length;
// };

// var removeDuplicates = function (nums) {
//   if (nums.length === 0) {
//     return 0;
//   }
//   let i = 0;
//   for (let j = 1; j < nums.length; j++) {
//     if (nums[j] !== nums[i]) {
//       nums[++i] = nums[j]
//     }
//   }
//   return i + 1;
// };

// 第2遍
// var removeDuplicates = function (nums) {
//   if (nums === null || nums.length <= 1) {
//     return nums ? nums.length : 0;
//   }
//   let i = 1;
//   for (let j = 1; j < nums.length; j++) {
//     if (nums[j] !== nums[j - 1]) {
//       nums[i++] = nums[j];
//     }
//   }
//   return i;
// };

var removeDuplicates = function (nums) {
  if (nums === null || nums.length <= 1) {
    return nums ? nums.length : 0;
  }
  let i = 0;
  for (let j = 1; j < nums.length; j++) {
    if (nums[j] !== nums[i]) {
      nums[++i] = nums[j];
    }
  }
  return i + 1;
};
// @lc code=end

// removeDuplicates([1,1,2])

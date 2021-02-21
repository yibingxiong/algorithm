/*
 * @lc app=leetcode.cn id=239 lang=javascript
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start

// 第1遍 过不了

// 1
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */
// var maxSlidingWindow = function (nums, k) {
//   if (nums.length < k) {
//     return [];
//   }
//   let res = [];

//   for (let i = 0; i <= nums.length - k; i++) {
//     let max = nums[i];
//     let m = 1;
//     while (m < k) {
//       if (nums[m + i] > max) {
//         max = nums[m + i]
//       }
//       m++;
//     }
//     res.push(max);
//   }
//   return res;
// };

// 2
// /**
//  * @param {number[]} nums
//  * @param {number} k
//  * @return {number[]}
//  */
var maxSlidingWindow = function (nums, k) {
  const queue = [];
  const res = [];
  if (nums.length < k) {
    return res;
  }
  for (let i = 0; i < nums.length; i++) {
    while (queue[0] <= i - k) {
      queue.shift();
    }
    while (queue.length && nums[queue[queue.length - 1]] < nums[i]) {
      queue.pop();
    }
    queue.push(i);
    if (i >= k - 1) {
      res.push(nums[queue[0]]);
    }
  }
  return res;
};
// @lc code=end


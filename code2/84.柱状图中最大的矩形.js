/*
 * @lc app=leetcode.cn id=84 lang=javascript
 *
 * [84] 柱状图中最大的矩形
 */

// @lc code=start

// 第1遍

// 1 纯暴力，遍历所有左右边界 过不了 O(n^3)
/**
 * @param {number[]} heights
 * @return {number}
 */
// var largestRectangleArea = function (heights) {
//   let max = 0;
//   for (let i = 0; i < heights.length; i++) {
//     for (let j = i; j < heights.length; j++) {
//       let min = heights[i];
//       for (let k = i; k <= j; k++) {
//         if (heights[k] < min) {
//           min = heights[k];
//         }
//       }
//       let area = min * (j - i + 1);
//       if (area > max) {
//         max = area;
//       }
//     }
//   }
//   return max;
// };

// 2 暴力加速 过不了 O(n^2)
/**
 * @param {number[]} heights
 * @return {number}
 */
// var largestRectangleArea = function (heights) {
//   let max = 0;
//   for (let i = 0; i < heights.length; i++) {
//     let left = i;
//     let right = i;
//     while (left > 0 && heights[left - 1] >= heights[i]) {
//       left--;
//     }
//     while (right < heights.length - 1 && heights[right + 1] >= heights[i]) {
//       right++;
//     }
//     let area = (right - left + 1) * heights[i];
//     if (area > max) {
//       max = area;
//     }
//   }
//   return max;
// };

// 3 单调栈
/**
 * @param {number[]} heights
 * @return {number}
 */
var largestRectangleArea = function (heights) {
  const stack = [];
  let max = 0;
  for (let i = 0; i < heights.length; i++) {
    while (stack.length > 0 && heights[i] < heights[stack[stack.length - 1]]) {
      let height = heights[stack.pop()];
      let width;
      if (stack.length === 0) {
        width = i;
      } else {
        width = i - stack[stack.length - 1] - 1;
      }
      max = Math.max(width * height, max);
    }
    stack.push(i);
  }

  while (stack.length > 0) {
    let height = heights[stack.pop()];
    let width;
    if (stack.length === 0) {
      width = heights.length;
    } else {
      width = heights.length - stack[stack.length - 1] - 1;
    }
    max = Math.max(width * height, max);
  }

  return max;
};

// @lc code=end


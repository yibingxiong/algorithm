/*
 * @lc app=leetcode.cn id=11 lang=javascript
 *
 * [11] 盛最多水的容器
 */

/* 
可能的解法分析：
1. 算出每两个柱子的面积，找到最大的
2. 双指针，从两边往中间，谁小就往中间挪，计算面积，找到最大的(看题解得到)
*/

// @lc code=start
/**
 * @param {number[]} height
 * @return {number}
 */
/////第一遍//////

// 方法1
// var maxArea = function (height) {
//   let i = 0;
//   let j = height.length - 1;
//   let max = 0;
//   while (i < j) {
//     let W = j - i;
//     let H = height[i] > height[j] ? height[j--] : height[i++];
//     max = Math.max(max, W*H);
//   }
//   return max;
// };

// 方法2
var maxArea = function (height) {
  let max = 0;
  for (let i = 0; i < height.length; i++) {
    for (let j = i + 1; j < height.length; j++) {
      let area = (j - i) * Math.min(height[i], height[j]);
      if (area > max) {
        max = area;
      }
    }
  }
  return max;
};
// @lc code=end


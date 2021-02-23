/*
 * @lc app=leetcode.cn id=42 lang=javascript
 *
 * [42] 接雨水
 */

// @lc code=start

// 第1遍 
// 1
// /**
//  * @param {number[]} height
//  * @return {number}
//  */
// var trap = function (height) {
//   if (height.length < 3) {
//     return 0;
//   }
//   const leftMax = [0, height[0]];

//   const rightMax = [];
//   rightMax[height.length - 1] = 0;
//   rightMax[height.length - 2] = height[height.length - 1];

//   for (let i = 2; i < height.length; i++) {
//     leftMax[i] = Math.max(leftMax[i - 1], height[i - 1])
//   }
//   for (let i = height.length - 3; i >= 0; i--) {
//     rightMax[i] = Math.max(rightMax[i + 1], height[i + 1])
//   }

//   let res = 0;
//   for (let i = 1; i < height.length - 1; i++) {
//     let min = Math.min(leftMax[i], rightMax[i]);
//     if (min > height[i]) {
//       res += min - height[i];
//     }
//   }
//   return res;
// };

// 2
/**
 * @param {number[]} height
 * @return {number}
 */
// var trap = function (height) {
//   let res = 0;
//   const stack = [];
//   let cur = 0;
//   while (cur < height.length) {
//     while (stack.length > 0 && height[cur] > height[stack[stack.length - 1]]) {
//       const top = stack.pop();
//       if (stack.length === 0) {
//         break;
//       }
//       const h = Math.min(height[cur], height[stack[stack.length - 1]]) - height[top];
//       const w = cur - stack[stack.length - 1] - 1;
//       res += h * w;
//     }
//     stack.push(cur++);
//   }
//   return res;
// };

// 2
var trap = function (height) {
  let leftMax = 0, rightMax = 0, res = 0;
  let left = 0, right = height.length - 1;
  while (left < right) {
    if (height[left] < height[right]) {
      if (height[left] >= leftMax) {
        leftMax = height[left];
      } else {
        res += (leftMax - height[left]);
      }
      left++;
    } else {
      if (height[right] >= rightMax) {
        rightMax = height[right];
      } else {
        res += (rightMax - height[right]);
      }
      right--;
    }
  }
  return res;
};
// trap([0,1,0,2,1,0,1,3,2,1,2,1])
// @lc code=end


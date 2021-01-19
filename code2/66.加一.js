/*
 * @lc app=leetcode.cn id=66 lang=javascript
 *
 * [66] 加一
 */

// @lc code=start
/**
 * @param {number[]} digits
 * @return {number[]}
 */

// 方法1
// var plusOne = function (digits) {
//   let s = 1;
//   let r = [];
//   let i = digits.length - 1;
//   for (i; i >= 0; i--) {
//     let a = digits[i] + s;
//     if (a >= 10) {
//       s = 1;
//       r.push(a - 10)

//     } else {
//       s = 0;
//       r.push(a);
//     }
//   }
//   if (s > 0) {
//     r.push(s);
//   }
//   return r.reverse();
// };

// 方法2 很妙
var plusOne = function (digits) {
  for (let i = digits.length - 1; i >= 0; i--) {
    if (digits[i] === 9) {
      digits[i] = 0;
    } else {
      digits[i] += 1;
      return digits
    }
  }
  digits.unFshift(1)
  return digits;

};
// @lc code=end


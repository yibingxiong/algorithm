/*
 * @lc app=leetcode.cn id=50 lang=javascript
 *
 * [50] Pow(x, n)
 */

// @lc code=start
// 第1遍
// 1
// /**
//  * @param {number} x
//  * @param {number} n
//  * @return {number}
//  */
// var myPow = function (x, n) {
//   let res = 1;
//   const N = Math.abs(n);
//   for (let i = 0; i < N; i++) {
//     res *= x;
//   }
//   if (n < 0) {
//     return 1 / res;
//   }
//   return res;
// };
// 2
// /**
//  * @param {number} x
//  * @param {number} n
//  * @return {number}
//  */
// var myPow = function (x, n) {
//   function pow(x, n) {
//     if (n === 0) {
//       return 1;
//     }
//     if (n === 1) {
//       return x;
//     }
//     const a = pow(x, Math.floor(n / 2));
//     if (n % 2 === 0) {
//       return a * a;
//     } else {
//       return a * a * x;
//     }
//   }
//   const b = pow(x, Math.abs(n));
//   if (n < 0) {
//     return 1 / b;
//   }
//   return b;
// };

// 3
// /**
//  * @param {number} x
//  * @param {number} n
//  * @return {number}
//  */
// var myPow = function (x, n) {
//   return Math.pow(x, n)
// };

// 4
/**
 * @param {number} x
 * @param {number} n
 * @return {number}
 */
var myPow = function (x, n) {
  function pow(x, n) {
    if (n === 0) return 1;
    if (n === 1) return x;
    const a = pow(x, Math.floor(n / 2));
    if (n % 2 === 0) {
      return a * a;
    } else {
      return a * a * x;
    }
  }
  const b = pow(x, Math.abs(n));
  if (n < 0) {
    return 1 / b;
  }
  return b;
};
// @lc code=end


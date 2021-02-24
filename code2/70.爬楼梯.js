/*
 * @lc app=leetcode.cn id=70 lang=javascript
 *
 * [70] 爬楼梯
 */

/* 
可能的解法：
1. 用递归的方法解,超时了,空间复杂度O(2^n)
2. 还是用递归的方法，不过加上缓存
3. 采用自底向上的方法, 时间O(n)空间O(n)
4. 改进3的做法，不开辟数组，每次都只保留前两次计算结果，时间O(n) 空间O(1)
5. 看题解，还有一种算法可以做到O(logn), 难度挺大，涉及矩阵相关知识
*/

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
// 方法1 递归加缓存
// var climbStairs = function (n) {
//   let m = {};
//   function cal(n) {
//     if (n == 1) {
//       return 1;
//     }
//     if (n == 2) {
//       return 2;
//     }
//     if (m[n]) {
//       return m[n];
//     }
//     m[n] = cal(n - 1) + cal(n - 2);
//     return m[n];
//   }
//   return cal(n);
// };

// 方法2
// var climbStairs = function (n) {
//   let s = [];
//   s[1] = 1;
//   s[2] = 2;
//   for (let i = 3; i <= n; i++) {
//     s[i] = s[i - 1] + s[i - 2];
//   }
//   return s[n];
// };

// 方法3
// var climbStairs = function (n) {
//   let a = 1;
//   let b = 2;
//   if (n === 1) {
//     return 1;
//   }
//   let res = 2;
//   for (let i = 3; i <= n; i++) {
//     res = a + b;
//     a = b;
//     b = res;
//   }
//   return res;
// };

// 方法4
var climbStairs = function (n) {
  let sqrt5 = Math.sqrt(5);
  let fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
  return Math.round(fibn / sqrt5);
};


// 第2遍

// 1

var climbStairs = function (n) {
  let a = 1;
  let b = 2;
  let res = 2;
  
  if (n === 1) {
    return 1;
  }
  for (let i = 3; i <= n; i++) {
    res = a + b;
    a = b;
    b = res;
  }
  return res;
};

// @lc code=end


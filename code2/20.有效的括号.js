/*
 * @lc app=leetcode.cn id=20 lang=javascript
 *
 * [20] 有效的括号
 */

// @lc code=start

// 第1遍

// 方法1
// /**
//  * @param {string} s
//  * @return {boolean}
//  */
// var isValid = function (s) {
//   if (!s) return true;
//   const stack = [];
//   const map = {
//     ')': '(',
//     ']': '[',
//     '}': '{',
//   }
//   for (let i = 0; i < s.length; i++) {
//     if (~Object.keys(map).indexOf(s[i])) {
//       const p = stack.pop();
//       if (p !== map[s[i]]) {
//         return false;
//       }
//     } else {
//       stack.push(s[i]);
//     }
//   }
//   return stack.length === 0;
// };

// 方法2
/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function (s) {
  const stack = [];
  for (let i = 0; i < s.length; i++) {
    switch (s[i]) {
      case '(': stack.push(')'); break;
      case '[': stack.push(']'); break;
      case '{': stack.push('}'); break;
      default:
        if (stack.length === 0 || stack.pop() !== s[i]) {
          return false;
        }
    }
  }
  return stack.length === 0;
};
// @lc code=end


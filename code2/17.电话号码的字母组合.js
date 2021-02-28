/*
 * @lc app=leetcode.cn id=17 lang=javascript
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
// 第1遍

// 1
// /**
//  * @param {string} digits
//  * @return {string[]}
//  */
// var letterCombinations = function (digits) {
//   if (!digits || digits.length === 0) {
//     return [];
//   }
//   const len = digits.length;
//   const res = [];
//   const map = {
//     2: ['a', 'b', 'c'],
//     3: ['d', 'e', 'f'],
//     4: ['g', 'h', 'i'],
//     5: ['j', 'k', 'l'],
//     6: ['m', 'n', 'o'],
//     7: ['p', 'q', 'r', 's'],
//     8: ['t', 'u', 'v'],
//     9: ['w', 'x', 'y', 'z'],
//   }

//   function calculate(str, pos) {
//     if (str.length === len) {
//       res.push(str);
//       return;
//     }
//     if (pos === len) {
//       return;
//     }
//     const b = map[digits[pos]];
//     for (let c of b) {
//       calculate(str + c, pos + 1);
//     }
//   }
//   calculate('', 0);
//   return res;
// };

// 2
/**
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations = function (digits) {
  if (!digits || digits.length === 0) {
    return [];
  }
  const len = digits.length;
  const map = {
    2: ['a', 'b', 'c'],
    3: ['d', 'e', 'f'],
    4: ['g', 'h', 'i'],
    5: ['j', 'k', 'l'],
    6: ['m', 'n', 'o'],
    7: ['p', 'q', 'r', 's'],
    8: ['t', 'u', 'v'],
    9: ['w', 'x', 'y', 'z'],
  }
  const queue = [...map[digits[0]]];
  for (let i = 1; i < len; i++) {
    let qLen = queue.length;
    const nowArr = map[digits[i]];
    while(qLen) {
      const s = queue.shift();
      for(const a of nowArr) {
        queue.push(s+a);
      }
      qLen--;
    }
  }
  return queue;
};
// @lc code=end


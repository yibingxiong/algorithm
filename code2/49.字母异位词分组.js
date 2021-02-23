/*
 * @lc app=leetcode.cn id=49 lang=javascript
 *
 * [49] 字母异位词分组
 */

// @lc code=start

// 第1遍

// 1
// /**
//  * @param {string[]} strs
//  * @return {string[][]}
//  */
// var groupAnagrams = function (strs) {
//   const strsMap = [];
//   function calStr(s) {
//     const map = {};
//     for (let i = 0; i < s.length; i++) {
//       if (!map[s[i]]) {
//         map[s[i]] = 0;
//       }
//       map[s[i]]++;
//     }
//     return map;
//   }
//   for (let i = 0; i < strs.length; i++) {
//     const map = calStr(strs[i]);
//     let s = '';
//     Object.keys(map).sort().forEach((a) => {
//       s += (a + "_" + map[a]);
//     })
//     strsMap.push(s);
//   }

//   const m = {}
//   for (let i = 0; i < strs.length; i++) {
//     if (!m[strsMap[i]]) {
//       m[strsMap[i]] = [];
//     }
//     m[strsMap[i]].push(strs[i]);
//   }
//   return Object.values(m);
// };

// 2
/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function (strs) {
  const map = {}
  for (let str of strs) {
    const s = str.split('').sort().join();
    if (!map[s]) map[s] = [];
    map[s].push(str);
  }
  return Object.values(map);
};

// @lc code=end


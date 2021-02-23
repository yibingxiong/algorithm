/*
 * @lc app=leetcode.cn id=242 lang=javascript
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function (s, t) {

  function calStr(s) {
    const map = {};
    for (let i = 0; i < s.length; i++) {
      if (!map[s[i]]) {
        map[s[i]] = 0;
      }
      map[s[i]]++;
    }
    return map;
  }
  if (s.length !== t.length) {
    return false;
  }
  const map1 = calStr(s);
  const map2 = calStr(t);

  for (let key of Object.keys(map1)) {
    if (!map2[key] || map2[key] !== map1[key]) {
      return false;
    }
  }
  return true;
};
// @lc code=end


/*
 * @lc app=leetcode.cn id=338 lang=typescript
 *
 * [338] 比特位计数
 */

// @lc code=start
function countBits(n: number): number[] {
  function count(n: number) {
    let res = 0;
    while (n != 0) {
      n = (n - 1) & n;
      res++;
    }
    return res;
  }
  const res = [];
  for (let i = 0; i <= n; i++) {
    res.push(count(i));
  }
  return res;
};
// @lc code=end


/*
 * @lc app=leetcode.cn id=191 lang=typescript
 *
 * [191] 位1的个数
 */

// @lc code=start
// function hammingWeight(n: number): number {
//   const s = n.toString(2).split('');
//   let res = 0;
//   for(let i = 0; i < s.length; i++) {
//     if (s[i] === '1') {
//       res++;
//     }
//   }
//   return res;
// };

function hammingWeight(n: number): number {
  let res = 0;
  while (n !== 0) {
    n = n & (n - 1);
    res++;
  }
  return res;
};

// function hammingWeight(n: number): number {
//   let res = 0;
//   for(let i = 0; i < 32; i++) {
//     if((n & (1 << i))) {
//       res++;
//     }
//   }
//   return res;
// };
// @lc code=end


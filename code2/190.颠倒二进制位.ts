/*
 * @lc app=leetcode.cn id=190 lang=typescript
 *
 * [190] 颠倒二进制位
 */

// @lc code=start
// function reverseBits(n: number): number {
//   return parseInt(n.toString(2).padStart(32, '0').split('').reverse().join(''), 2)
// };
// function reverseBits(n: number): number {
//   var result = 0;
//   var count = 32;

//   while (count--) {
//     result *= 2;
//     result += n & 1;
//     n = n >> 1;
//   }
//   return result;
// }
// function reverseBits(n: number): number {
//   var result = 0;
//   for (let i = 0; i < 32; i++) {
//     result = (result << 1) + (n >> i & 1)
//   }
//   return result;
// }

function reverseBits(n: number): number {
  let ans = 0;
  for (let i = 0; i < 32 && n > 0; ++i) {
    ans = ans | (n & 1) << (31 - i);
    n >>>= 1;
  }
  return ans >>> 0;
}


// @lc code=end


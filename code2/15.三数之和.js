/*
 * @lc app=leetcode.cn id=15 lang=javascript
 *
 * [15] 三数之和
 */

/* 
可能的解法
1. 第一个想到的就是暴力解了，每三个数算一次，
和为0就是解，时间复杂度O(n^3),空间O(n), 用一个set做去重. 过不了
1.1 先排序，再做，这样去重会方便一些,时间O(n^3),空间O(1). 也过不了，过了
315/318,有三个比较长的case过不了
2. 遍历一遍，建立数字和位置的映射map。两个两个算，用和的相反数去map查，
做一些判断和处理即可时间O(n^2)，空间O(n) 这种能通过，不过效率也很低
3. 利用有序性 + 双指针的思路，时间O(n^2),空间O(1)
*/
// @lc code=start
// 方法1
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
// var threeSum = function (nums) {
//   let len = nums.length;
//   let res = [];
//   const set = new Set();
//   for (let i = 0; i < len; i++) {
//     for (let j = i + 1; j < len; j++) {
//       for (let k = j + 1; k < len; k++) {
//         if (nums[i] + nums[j] + nums[k] === 0) {
//           let r = [
//             nums[i],
//             nums[j],
//             nums[k]
//           ]
//           r.sort((a, b) => a - b);
//           let key = r.join('#');
//           if (!set.has(key)) {
//             set.add(key);
//             res.push(r)
//           }
//         }
//       }
//     }
//   }
//   return res;
// };

// 方法2
// var threeSum = function (nums) {
//   nums.sort((a, b) => a - b);
//   let res = [];
//   for (let i = 0; i < nums.length - 2; i++) {
//     if (i > 0 && nums[i] === nums[i - 1]) {
//       continue;
//     }
//     for (let j = i + 1; j < nums.length - 1; j++) {
//       if (j > i + 1 && nums[j] === nums[j - 1]) {
//         continue;
//       }
//       for (let k = j + 1; k < nums.length; k++) {
//         if (k > j + 1 && nums[k] === nums[k - 1]) {
//           continue;
//         }
//         if (nums[i] + nums[j] + nums[k] === 0) {
//           res.push([nums[i], nums[j], nums[k]])
//         }
//       }
//     }
//   }
//   return res
// }

// 方法3
// var threeSum = function (nums) {
//   nums.sort((a, b) => a - b);
//   const map = {};
//   for (let i = 0; i < nums.length; i++) {
//     map[nums[i]] = [];
//   }
//   for (let i = 0; i < nums.length; i++) {
//     map[nums[i]].push(i);
//   }
//   let res = [];
//   for (let i = 0; i < nums.length - 2; i++) {
//     if (i > 0 && nums[i] === nums[i - 1]) {
//       continue;
//     }
//     for (let j = i + 1; j < nums.length - 1; j++) {
//       if (j > i + 1 && nums[j] === nums[j - 1]) {
//         continue;
//       }
//       let twoSumR = -(nums[i] + nums[j]);
//       let t = map[twoSumR];
//       let tLen = t ? t.length : 0;
//       if (tLen === 0) {
//         continue;
//       }
//       let repeatNum = 0;
//       if (nums[i] === twoSumR) {
//         repeatNum++;
//       }
//       if (nums[j] === twoSumR) {
//         repeatNum++;
//       }

//       if (tLen > repeatNum && t[tLen - 1] > j) { // 必须要找j后边的位置，否则有可能重复
//         res.push([
//           nums[i],
//           nums[j],
//           twoSumR
//         ])
//       }
//     }
//   }
//   return res
// }

// 方法4
var threeSum = function (nums) {
  nums.sort((a, b) => a - b);
  let res = [];
  let len = nums.length;
  for (let i = 0; i < len; i++) {
    if (nums[i] > 0) { // 这里参考题解做了一个优化，很厉害
      continue;
    }
    if (i > 0 && nums[i] === nums[i - 1]) {
      continue;
    } 
    let t = -nums[i];
    let m = i + 1;
    let n = len - 1;
    while (m < n) {
      if (m > i + 1 && nums[m] === nums[m - 1]) { // 去重
        m++;
        continue;
      }
      if (n < len - 1 && nums[n] === nums[n + 1]) {
        n--;
        continue;
      }
      let sum = nums[m] + nums[n];
      if (sum === t) {
        res.push([
          nums[i],
          nums[m],
          nums[n]
        ]);
        m++;
        n--;
      } else if (sum > t) {
        n--;
      } else {
        m++;
      }
    }
  }
  return res
}

// @lc code=end


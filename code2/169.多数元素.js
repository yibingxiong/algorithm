/*
 * @lc app=leetcode.cn id=169 lang=javascript
 *
 * [169] 多数元素
 */

// @lc code=start
// 第1遍
// 1
// /**
//  * @param {number[]} nums
//  * @return {number}
//  */
// var majorityElement = function(nums) {
//     const map = {};
//     const L = Math.floor(nums.length / 2);
//     for (let n of  nums) {
//         if (!map[n]) {
//             map[n] = 0;
//         }
//         map[n] = map[n] + 1;
//         if (map[n] > L) {
//             return n;
//         }
//     }
//     return null;
// };

// 2
// /**
//  * @param {number[]} nums
//  * @return {number}
//  */
// var majorityElement = function(nums) {
//     nums.sort();
//     return nums[Math.floor(nums.length / 2)]
// };

// // 3
// /**
//  * @param {number[]} nums
//  * @return {number}
//  */
// var majorityElement = function(nums) {
//     let major = nums[0], count= 1, len = nums.length;
//     for (let i = 1; i < len; i++) {
//         if (count === 0) {
//             major = nums[i];
//             count = 1;
//         } else if (nums[i] === major) {
//             count++;
//         } else {
//             count--;
//         }
//     }
//     return major;
// };

// 4
/**
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function (nums) {
    let res = null, c = 0;
    for (const i of nums) {
        if (c === 0) {
            res = i;
            c = 1;
        } else if (i === res) {
            c++;
        } else {
            c--;
        }
    }
    return res;
};
// @lc code=end


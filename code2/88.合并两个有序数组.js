/*
 * @lc app=leetcode.cn id=88 lang=javascript
 *
 * [88] 合并两个有序数组
 */
/* 
1. 开辟一个数组,拷进去,然后拷到nums1
2. 将nums2逐个插入到nums1的合适的位置,从后开始
*/
// @lc code=start
/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
// 方法1
// var merge = function (nums1, m, nums2, n) {
//     let help = [];
//     let i = 0, j = 0;
//     while(i < m && j < n) {
//         if (nums1[i] < nums2[j]) {
//             help.push(nums1[i++]);
//         } else {
//             help.push(nums2[j++]);
//         }
//     }
//     while(i < m) {
//         help.push(nums1[i++]);
//     }
//     while(j < n) {
//         help.push(nums2[j++]);
//     }
//     for(i = 0; i < (m+n); i++) {
//         nums1[i] = help[i];
//     }
// };


// 第2遍

// 1 一个一个插入 时间O(mn) 空间O(1)
// var merge = function (nums1, m, nums2, n) {
//     for (let i = 0; i < n; i++) {
//         let t = nums2[i];
//         let pos = m + i;
//         while (pos > 0 && nums1[pos - 1] > t) {
//             nums1[pos] = nums1[pos - 1];
//             pos--;
//         }
//         nums1[pos] = t;
//     }
// };

// 2 从后往前，省空间，每次都找最大
var merge = function (nums1, m, nums2, n) {
    let i = m - 1;
    let j = n - 1;
    let k = m + n - 1;
    while (i >= 0 && j >= 0) {
        nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
    }
    while (j >= 0) {
        nums1[k--] = nums2[j--];
    }
};
// let a = [9, 10, 11, 12]
// merge(a, 4, [3, 4, 5], 3)
// console.log(a.join(','))
// @lc code=end


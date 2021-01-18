/*
 * @lc app=leetcode.cn id=189 lang=javascript
 *
 * [189] 旋转数组
 */

/* 
可能的解法：
1. 构造一个辅助数组，拷贝进去，然后拷回去，
时间O(n) 空间O(n)
2. 将最后一个移动到第一个，重复k次
时间O(nk) 空间O(1)
3. 对1改进，将空间降到O(k), 将后k个拷贝出来，然后每个元素
向后挪k个位置，将拷贝出来的k个元素放到最前面
4. 先整体reverse，然后reverse前k个，然后reverse后n-k个
时间O(n) 空间O(1)
*/
// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
// 方法1
// var rotate = function (nums, k) {
//   let help = [];
//   let len = nums.length;
//   let normalK = k % len;
//   for (let i = 1; i <= normalK; i++) {
//     help[normalK - i] = nums[len - i]
//   }
//   for (let i = normalK; i < len; i++) {
//     help[i] = nums[i - normalK];
//   }
//   for (let i = 0; i < len; i++) {
//     nums[i] = help[i]
//   }
// };

// 方法2
// var rotate = function (nums, k) {
//   k = k % nums.length;
//   for (let i = 0; i < k; i++) {
//     moveLast2First(nums);
//   }
// };

// function moveLast2First(nums) {
//   let last = nums[nums.length - 1];
//   let i = nums.length - 1;
//   while (i > 0) {
//     nums[i--] = nums[i];
//   }
//   nums[0] = last;
// }

// 方法3
var rotate = function (nums, k) {
  k = k % nums.length;
  reverse(nums, 0, nums.length - 1);
  reverse(nums, 0, k - 1);
  reverse(nums, k, nums.length - 1);
};

function reverse(nums, i, j) {
  for (let k = 0; k <= (j - i) / 2; k++) {
    let t = nums[i + k];
    nums[i + k] = nums[j - k];
    nums[j - k] = t;
  }
}

// @lc code=end


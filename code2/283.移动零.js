/*
 * @lc app=leetcode.cn id=283 lang=javascript
 *
 * [283] 移动零
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */

/* 
可能的思路分析：
1. 从后往前遍历，记录下一个0应该放的位置（j），遇到0，就一直将他往后挪
直到挪到下一个0的位置（j），j--; 继续往前处理，直到到达第一个元素

2. 从前往后遍历，用一个j记录下一个非0应该在的位置，遇到0直接往后跳
遇到非0，交换j和当前数，j++, 依次处理完所有数，从j开始直到数组末尾
全部置为0; 空间复杂度O(1) 时间复杂度O(n)

3. 建立一个同样大小的空数组，遍历元数组，遇到非0就往空数组加，最后将
空数组剩余部分置为0，拷贝回去。

这种方式显然空间复杂度为O(n), 时间复杂度O(n)

 */


/**
 * 方法一
 * 
 * 时间复杂度O(n^2)
 */
function swap(nums, i, j) {
  let a = nums[i];
  nums[i] = nums[j];
  nums[j] = a;
}
// var moveZeroes = function (nums) {
//   let j = nums.length - 1;
//   let i = nums.length - 1;
//   while (i >= 0) {
//     if (nums[i] === 0) {
//       for (let m = i + 1; m <= j; m++) {
//         swap(nums, m, m - 1);
//       }
//       j--;
//     }
//     i--;
//   }
// };

/**
 * 
 * 方法2
 */
// var moveZeroes = function (nums) {
//   let j = 0;
//   let len = nums.length;
//   let i = 0;
//   for (i = 0; i < len; i++) {
//     if (nums[i] !== 0) {
//       swap(nums, i, j++);
//     }
//   }
// };

/**
 * 方法3
 */
// var moveZeroes = function (nums) {
//   let nums2 = [];
//   for (let i = 0; i < nums.length; i++) {
//     if (nums[i] !== 0) {
//       nums2.push(nums[i]);
//     }
//   }
//   let i2 = nums2.length - 1;
//   for (let i = 0; i < nums.length; i++) {
//     if (i <= i2) {
//       nums[i] = nums2[i]
//     } else {
//       nums[i] = 0;
//     }
//   }
// }

///////////////第2遍///////////

// var moveZeroes = function (nums) {
//   let i,j;
//   i = j = 0;
//   let len = nums.length;
//   while(j < len) {
//     if (nums[j] !== 0) {
//       swap(nums, i++, j);
//     }
//     j++;
//   }
// };

// 这种方法应该是最优解了，前面这个因为swap操作的成本比较高了
var moveZeroes = function (nums) {
  let i,j;
  i = j = 0;
  let len = nums.length;
  while(j < len) {
    if (nums[j] !== 0) {
      nums[i++] = nums[j]
    }
    j++;
  }
  while(i < len) {
    nums[i++] = 0;
  }
};

// @lc code=end


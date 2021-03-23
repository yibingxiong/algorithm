/*
 * @lc app=leetcode.cn id=51 lang=javascript
 *
 * [51] N 皇后
 */

// @lc code=start
/**
 * @param {number} n
 * @return {string[][]}
 */
var solveNQueens = function(n) {
    const res = [];
    function solve(pre, row, col) {
        if (row === n && col === n) {
            res.push(pre);
            return;
        }
        
    }
};
// @lc code=end


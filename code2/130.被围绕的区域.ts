/*
 * @lc app=leetcode.cn id=130 lang=typescript
 *
 * [130] 被围绕的区域
 */

// @lc code=start
/**
 Do not return anything, modify board in-place instead.
 */
function solve(board: string[][]): void {
  const r = board.length;
  const c = board[0].length;

  function dfs(i, j) {
    if (i < 0 || j < 0 || i >= r || j >= c) return;
    if (board[i][j] === 'O') {
      board[i][j] = '@';
      dfs(i, j - 1);
      dfs(i, j + 1);
      dfs(i - 1, j);
      dfs(i + 1, j);
    }
  }

  [0, c - 1].forEach(curC => {
    for (let i = 0; i < r; i++) {
      if (board[i][curC] === 'O') {
        dfs(i, curC);
      }
    }
  });

  [0, r - 1].forEach(curR => {
    for (let i = 0; i < c; i++) {
      if (board[curR][i] === 'O') {
        dfs(curR, i);
      }
    }
  });


  for (let i = 0; i < r; i++) {
    for (let j = 0; j < c; j++) {
      if (board[i][j] === '@') {
        board[i][j] = 'O'
      } else {
        board[i][j] = 'X';
      }
    }
  }
};
// @lc code=end


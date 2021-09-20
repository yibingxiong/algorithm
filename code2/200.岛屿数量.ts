/*
 * @lc app=leetcode.cn id=200 lang=typescript
 *
 * [200] 岛屿数量
 */

// @lc code=start
function numIslands(grid: string[][]): number {
  const r = grid.length;
  const c = grid[0].length;
  let res = 0;

  function dfs(i: number, j: number): void {
    if (i < 0 || j < 0 || i >= r || j >= c) return;
    if (grid[i][j] === '1') {
      grid[i][j] = '0';
      dfs(i, j + 1);
      dfs(i, j - 1);
      dfs(i + 1, j);
      dfs(i - 1, j);
    }
  }

  for (let i = 0; i < r; i++) {
    for (let j = 0; j < c; j++) {
      if (grid[i][j] === '1') {
        dfs(i, j);
        res++;
      }
    }
  }

  return res;
};
// @lc code=end


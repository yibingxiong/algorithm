/*
 * @lc app=leetcode.cn id=547 lang=javascript
 *
 * [547] 省份数量
 */

// @lc code=start

// 方法1： 并查集
// class UnionFind {
//   constructor(n) {
//     this.count = n;
//     this.parent = [];
//     for (let i = 0; i < n; i++) {
//       this.parent[i] = i;
//     }
//   }
//   find(p) {
//     let parent = this.parent;
//     while (parent[p] !== p) {
//       parent[p] = parent[parent[p]];
//       p = parent[p];
//     }
//     return p;
//   }
//   union(p, q) {
//     const pS = this.find(p);
//     const qS = this.find(q);
//     if (pS !== qS) {
//       this.parent[pS] = qS;
//       this.count--;
//     }
//   }
//   getCount() {
//     return this.count;
//   }
// }
// /**
//  * @param {number[][]} isConnected
//  * @return {number}
//  */
// var findCircleNum = function (isConnected) {
//   const h = isConnected.length;
//   const w = isConnected[0].length;
//   const unionFind = new UnionFind(h);
//   for (let i = 0; i < h; i++) {
//     for (let j = i + 1; j < w; j++) {
//       if (isConnected[i][j] === 1) {
//         unionFind.union(i, j);
//       }
//     }
//   }
//   return unionFind.getCount();
// };



// 方法2： dfs

/**
 * @param {number[][]} isConnected
 * @return {number}
 */
var findCircleNum = function (isConnected) {
  const c = isConnected.length;
  
  const visited = [];
  let res = 0;
  for(let i = 0; i < c; i++) {
    if (!visited[i]) {
      visited[i] = true;
      dfs(i, visited);
      res++;
    }
  }

  function dfs(i, visited) {
    for (let j = 0; j < c; j++) {
      if (isConnected[i][j]===1 && !visited[j]) {
        visited[j] = true;
        dfs(j, visited);
      }
    }
  }

  return res;
};
// @lc code=end


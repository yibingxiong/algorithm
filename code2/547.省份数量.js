/*
 * @lc app=leetcode.cn id=547 lang=javascript
 *
 * [547] 省份数量
 */

// @lc code=start

class UnionFind {
  constructor(n) {
    this.count = n;
    this.parent = [];
    for (let i = 0; i < n; i++) {
      this.parent[i] = i;
    }
  }
  find(p) {
    let parent = this.parent;
    while (parent[p] !== p) {
      parent[p] = parent[parent[p]];
      p = parent[p];
    }
    return p;
  }
  union(p, q) {
    const pS = this.find(p);
    const qS = this.find(q);
    if (pS !== qS) {
      this.parent[pS] = qS;
      this.count--;
    }
  }
  getCount() {
    return this.count;
  }
}
/**
 * @param {number[][]} isConnected
 * @return {number}
 */
var findCircleNum = function (isConnected) {
  const h = isConnected.length;
  const w = isConnected[0].length;
  const unionFind = new UnionFind(h);
  for (let i = 0; i < h; i++) {
    for (let j = i + 1; j < w; j++) {
      if (isConnected[i][j] === 1) {
        unionFind.union(i, j);
      }
    }
  }
  return unionFind.getCount();
};
// @lc code=end


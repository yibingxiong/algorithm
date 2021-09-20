/*
 * @lc app=leetcode.cn id=212 lang=javascript
 *
 * [212] 单词搜索 II
 */

// @lc code=start
/**
 * @param {character[][]} board
 * @param {string[]} words
 * @return {string[]}
 */
var findWords = function (board, words) {
  // 构造trie树
  const trie = {};
  for (let i = 0; i < words.length; i++) {
    const word = words[i];
    let node = trie;
    for (let j = 0; j < word.length; j++) {
      const ch = word.charAt(j);
      if (!node[ch]) {
        node[ch] = {};
      }
      node = node[ch];
    }
    node.isEnd = true;
  }

  const res = new Set();
  const h = board.length;
  const w = board[0].length;
  // dfs
  function dfs(i, j, trie, word) {
    if (trie.isEnd) {
      res.add(word);
    }
    if (i < 0 || j < 0 || i >= h || j >= w) {
      return;
    }

    if (!trie[board[i][j]]) {
      return;
    }
    const temp = board[i][j];
    board[i][j] = '#';
    word += temp;
    dfs(i, j - 1, trie[temp], word);
    dfs(i, j + 1, trie[temp], word);
    dfs(i - 1, j,trie[temp], word);
    dfs(i + 1, j,trie[temp], word);

    board[i][j] = temp;
  }


  for (let i = 0; i < h; i++) {
    for (let j = 0; j < w; j++) {
      dfs(i, j, trie, '');
    }
  }
  return [...res];
};

findWords([["a","b"]], ["ba"])
// @lc code=end


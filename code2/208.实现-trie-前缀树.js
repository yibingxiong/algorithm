/*
 * @lc app=leetcode.cn id=208 lang=javascript
 *
 * [208] 实现 Trie (前缀树)
 */

// @lc code=start
/**
 * Initialize your data structure here.
 */
var Trie = function() {
    this.children = {};
    this.isEnd = false;
};

/**
 * Inserts a word into the trie. 
 * @param {string} word
 * @return {void}
 */
Trie.prototype.insert = function(word) {
  let node =  this;
  for (let i = 0; i < word.length; i++) {
    const ch = word.charAt(i)
    if (!node.children[ch]) {
      node.children[ch] = new Trie();
    }
    node = node.children[ch];
  }
  node.isEnd = true;
};

/**
 * Returns if the word is in the trie. 
 * @param {string} word
 * @return {boolean}
 */
Trie.prototype.search = function(word) {
  const node =  this.searchPrefix(word);
  return node !== null && node.isEnd;
};

Trie.prototype.searchPrefix = function(word) {
  let node  = this;
  for (let i = 0; i < word.length; i++) {
    const ch = word.charAt(i);
    if (node.children[ch]) {
      node = node.children[ch];
    } else {
      return null;
    }
  }
  return node;
}

/**
 * Returns if there is any word in the trie that starts with the given prefix. 
 * @param {string} prefix
 * @return {boolean}
 */
Trie.prototype.startsWith = function(prefix) {
  return !!this.searchPrefix(prefix);
};

/**
 * Your Trie object will be instantiated and called as such:
 * var obj = new Trie()    
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */

// const trie = new Trie();
// const b = trie.search('a');
// console.log(b);
// @lc code=end


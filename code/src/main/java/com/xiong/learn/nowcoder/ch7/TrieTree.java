package com.xiong.learn.nowcoder.ch7;

import com.sun.scenario.animation.shared.TimerReceiver;

public class TrieTree {
    public class TrieNode {
        public int end;
        public int path;
        public TrieNode[] nexts;

        public TrieNode() {
            this.end = 0;
            this.path = 0;
            this.nexts = new TrieNode[26];
        }
    }

    public TrieNode root;

    public TrieTree() {
        this.root = new TrieNode();
    }

    public void insert(String str) {
        if (str == null) {
            return;
        }
        char[] chars = str.toCharArray();
        TrieNode node = this.root;

        for (int i = 0; i < chars.length; i++) {
            TrieNode[] nexts = node.nexts;
            int index = chars[i] - 'a';
            if (nexts[index] == null) {
                nexts[index] = new TrieNode();
            }
            nexts[index].path++;
            node = node.nexts[index];
        }
        node.end++;
    }

    public int search(String string) {
        if (string == null) {
            return 0;
        }
        char[] chars = string.toCharArray();

        TrieNode node = this.root;

        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            TrieNode[] nexts = node.nexts;
            if (nexts[index] == null) {
                return 0;
            }
            node = nexts[index];
        }
        return node.end;
    }

    public void delete(String string) {
        if (string == null) {
            return;
        }
        char[] chars = string.toCharArray();

        TrieNode node = this.root;

        for (int i = 0; i < chars.length; i++) {
            TrieNode[] nexts = node.nexts;
            int index = chars[i] - 'a';
            if (nexts[index] == null) { // 不存在
                return;
            }
            nexts[index].path--;
            if (nexts[index].path == 0) { // 说明下边的路径绝对没有了
                nexts[index] = null;
                return;
            }
            node = nexts[index];
        }
        node.end--;
    }

    public static void main(String[] args) {
        TrieTree trieTree = new TrieTree();
        trieTree.insert("abc");
        int abc = trieTree.search("abc");
        System.out.println(abc);
        System.out.println(trieTree.search("a"));
        trieTree.insert("abc");
        trieTree.insert("abcd");
        System.out.println(trieTree.search("abc"));
        trieTree.delete("abc");
        System.out.println(trieTree.search("abc"));
        trieTree.delete("abd");
        System.out.println(trieTree.search("abc"));
        trieTree.delete("abc");
        System.out.println(trieTree.search("abc"));
    }
}

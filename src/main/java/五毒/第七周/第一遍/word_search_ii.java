package 五毒.第七周.第一遍;

import java.util.*;

public class word_search_ii {


    public Trie trie;

    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        int n = board[0].length;
        List<String> result = new ArrayList<>();
        trie = new Trie();
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        for (int i = 0; i < words.length; i++) {
            trie.insert(words[i]);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(result, "",new HashSet<>(), i, j, board, wordSet);
            }
        }
        return result;
    }

    private void dfs(List<String> result, String str,Set<String> visited, int i, int j, char[][] board, Set<String> wordSet) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }

        String newStr = str+board[i][j];
        if(wordSet.isEmpty()){
            return;
        }
        if (visited.contains(i + "," + j)) {
            return;
        }

        if(!trie.startsWith(newStr)){
            return;
        }
        if(wordSet.contains(newStr)){
            result.add(newStr);
            wordSet.remove(newStr);
        }


        visited.add(i+","+j);
        dfs(result,newStr,visited,i-1,j,board,wordSet);
        dfs(result,newStr,visited,i+1,j,board,wordSet);
        dfs(result,newStr,visited,i,j-1,board,wordSet);
        dfs(result,newStr,visited,i,j+1,board,wordSet);
    }

    private class Trie {
        private class TrieNode {
            private TrieNode[] links;
            private Boolean isEnd;

            public TrieNode() {
                isEnd = false;
                links = new TrieNode[26];
            }

            private void put(char c, TrieNode node) {
                if (!contains(c)) {
                    links[c - 'a'] = node;
                }
            }

            private Boolean contains(char c) {
                return links[c - 'a'] != null;
            }

            private TrieNode get(char c) {
                return links[c - 'a'];
            }

            private void setEnd() {
                isEnd = true;
            }

        }

        /**
         * Initialize your data structure here.
         */
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            char[] chars = word.toCharArray();
            TrieNode root = this.root;
            for (int i = 0; i < chars.length; i++) {
                root.put(chars[i], new TrieNode());
                root = root.get(chars[i]);
            }
            root.setEnd();
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            char[] chars = word.toCharArray();
            TrieNode root = this.root;
            for (int i = 0; i < chars.length; i++) {
                if (!root.contains(chars[i])) {
                    return false;
                }
                root = root.get(chars[i]);
            }
            return root.isEnd;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode root = this.root;
            char[] chars = prefix.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (!root.contains(chars[i])) {
                    return false;
                }
                root = root.get(chars[i]);
            }
            return true;
        }
    }
}

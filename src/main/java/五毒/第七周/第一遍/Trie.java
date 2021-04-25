package 五毒.第七周.第一遍;

class Trie {
    private class TrieNode {
        private TrieNode[] links;
        private Boolean isEnd;

        public TrieNode() {
            isEnd  =false;
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


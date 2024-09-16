class trieNode {
    public trieNode[] children = new trieNode[26];
    public boolean isWord = false;
}

class WordDictionary {
    public void addWord(String word) {
        trieNode node = root;
        for (final char c : word.toCharArray()) {
            final int i = c - 'a';
            if (node.children[i] == null)
                node.children[i] = new trieNode();
            node = node.children[i];
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private trieNode root = new trieNode();

    private boolean dfs(String word, int s, trieNode node) {
        if (s == word.length())
            return node.isWord;
        if (word.charAt(s) != '.') {
            trieNode next = node.children[word.charAt(s) - 'a'];
            return next == null ? false : dfs(word, s + 1, next);
        }

        // If word[s] == '.', then search all the 26 children.
        for (int i = 0; i < 26; ++i)
            if (node.children[i] != null && dfs(word, s + 1, node.children[i]))
                return true;

        return false;
    }
}

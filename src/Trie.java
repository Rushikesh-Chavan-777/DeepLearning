class TrieNode {
    public trieNode[] children = new trieNode[26];
    public boolean isWord = false;
}

class Trie {
    public void insert(String word) {
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
        trieNode node = find(word);
        return node != null && node.isWord;
    }

    public boolean startsWith(String prefix) {
        return find(prefix) != null;
    }

    private trieNode root = new trieNode();

    private trieNode find(String prefix) {
        trieNode node = root;
        for (final char c : prefix.toCharArray()) {
            final int i = c - 'a';
            if (node.children[i] == null)
                return null;
            node = node.children[i];
        }
        return node;
    }
}
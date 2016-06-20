public class WordDictionary {
    private TrieNode root;
    
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            int index = (int)(word.charAt(i) - 'a');
            if(node.getChild(index) == null) {
                node.createChild(index);
            }
            node = node.getChild(index);
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        if(word == null || word.isEmpty()) {
            return false;
        }
        return search(word, 0, root);
    }
    
    private boolean search(String word, int index, TrieNode root) {
        char c = word.charAt(index);
        if(root == null) {
            return false;
        } else if(index == word.length() - 1) {
            if(c != '.') {
                TrieNode child = root.getChild(c - 'a');
                return child != null && child.isWord;
            } else {
                for(int i = 0; i < 26; i++) {
                    TrieNode child = root.getChild(i);
                    if(child != null && child.isWord) {
                        return true;
                    }
                }
                return false;
            }
        }
        
        if(c == '.') {
            for(int i = 0; i < 26; i++) {
                if(search(word, index+1, root.getChild(i))) {
                    return true;
                }
            }
            return false;
        } 
        
        return search(word, index+1, root.getChild(c - 'a'));
    }
    
    class TrieNode {
        public boolean isWord; 
        public TrieNode[] children;
        public TrieNode() {
            isWord = false;
            children = new TrieNode[26];
        }
        
        public TrieNode getChild(int index) {
            return children[index];
        }
        public TrieNode createChild(int index) {
            if(getChild(index) == null) {
                children[index] = new TrieNode();
            }
            return children[index];
        }
    }
}
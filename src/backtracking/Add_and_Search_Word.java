package backtracking;

public class WordDictionary {
    private TrieNode root;
    
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode ws = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(ws.children[c - 'a'] == null){
                ws.children[c - 'a'] = new TrieNode();
            }
            ws = ws.children[c - 'a'];
        }
        ws.isWord = true;
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }
    
    private boolean search(String word, int index, TrieNode root) {
        char c = word.charAt(index);
        if(root == null) {
            return false;
        } else if(index == word.length() - 1) {
            if(c != '.') {
                TrieNode child = root.children[c - 'a'];
                return child != null && child.isWord;
            } else {
                for(int i = 0; i < 26; i++) {
                    TrieNode child = root.children[i];
                    if(child == null) {
                        continue;
                    } else if(child.isWord) {
                        return true;
                    }
                }
                return false;
            }
        }
        
        if(c == '.') {
            for(int i = 0; i < 26; i++) {
                if(search(word, index+1, root.children[i])) {
                    return true;
                }
            }
            return false;
        } 
        
        return search(word, index+1, root.children[c - 'a']);
    }
    
    class TrieNode {
        public boolean isWord; 
        public TrieNode[] children = new TrieNode[26];
        public TrieNode() {}
    }
}
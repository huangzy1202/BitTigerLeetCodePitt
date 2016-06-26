public class WordDictionary {

    public node root;
    public WordDictionary() {
        root = new node(' ');
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        root.addOne(word,0);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return root.search(word,0);
    }

    public class node {

        public char character;
        public node[] children = new node[26];
        public boolean stop = false;

        public node (char c) {
            if (c >= 'a') {
                this.character = (char) (c - 32);
            } else {
                this.character = c;
            }
        }

        public void addOne(String word, int curIndex) {

            if (curIndex >= word.length()) {
                return;
            }

            int index = word.charAt(curIndex) - 'a';
            if (this.children[index] == null) {
                this.children[index] = new node(word.charAt(curIndex));
            }
            this.children[index].addOne(word,curIndex+1);
            if (curIndex+1 == word.length()) {
                this.stop = true;
            }
        }

        public boolean search(String word, int curIndex) {
            int nextIndex;
            char curChar = word.charAt(curIndex);
           
            if (word.charAt(curIndex) == '.') {
                if (curIndex == word.length()-1) {
                    if (this.stop) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    for (int i = 0; i < children.length; i++) {
                        if (this.children[i] != null && this.children[i].search(word,curIndex+1)) {
                            return true;
                        }
                    }
                }
            } else {
                if (curChar >= 'a') {
                    nextIndex = curChar - 'a';
                } else {
                    nextIndex = curChar - 'A';
                }

                if (this.children[nextIndex] != null) {
                    if (curIndex == word.length()-1) {
                        if (this.stop) {
                            return true;
                        } else {
                            return false;
                        }
                    } else {
                        return this.children[nextIndex].search(word,curIndex+1);
                    }
                }
            }
            return false;
        }

    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");

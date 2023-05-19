package Blind75.Tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ImplementTrie {

    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */

    static class TrieNode{
        Character data;
        HashMap<Character, TrieNode> children;
        boolean isEnd;

        public TrieNode(Character data){
            this.data = data;
            this.children = new HashMap<>();
            this.isEnd = false;
        }
    }

    static class Trie {

        TrieNode root;

        public Trie() {
            this.root = new TrieNode(' '); // create empty (dummy) node
        }

        public void insert(String word) {
            if (search(word)) {
                System.out.println("Word " + word + " is already exists in trie!");
            } else {
                TrieNode temp = root;
                for (Character ch : word.toCharArray()) {
                    if (!temp.children.containsKey(ch)) {
                        temp.children.put(ch, new TrieNode(ch));
                    }
                    temp = temp.children.get(ch);
                }
                temp.isEnd = true;
            }
        }

        public boolean search(String word) {
            TrieNode temp = this.root;
            for(Character ch: word.toCharArray()){
                if(temp.children.containsKey(ch)){
                    temp = temp.children.get(ch);
                }
                else return false;
            }
            return temp.isEnd;
        }

        public boolean startsWith(String prefix) {
            TrieNode temp = this.root;
            for(Character ch: prefix.toCharArray()){
                if(!temp.children.containsKey(ch)){
                    return false;
                }
                temp = temp.children.get(ch);
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        boolean param_2 = trie.search("apple");
        boolean param_3 = trie.search("app");
        boolean param_4 = trie.startsWith("app");
        trie.insert("app");
        boolean param_5 = trie.search("app");
        System.out.println(param_2); // true
        System.out.println(param_3); // false
        System.out.println(param_4); // true
        System.out.println(param_5); // true

    }
}

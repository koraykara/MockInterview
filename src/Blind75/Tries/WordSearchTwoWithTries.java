package Blind75.Tries;

import java.util.*;
import java.util.stream.Collectors;

import static Blind75.Tries.WordSearchII.helper;

public class WordSearchTwoWithTries {

    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */

    static class TrieNode {
        Character data;
        HashMap<Character, TrieNode> children;
        boolean isEnd;

        public TrieNode(Character data) {
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
            for (Character ch : word.toCharArray()) {
                if (temp.children.containsKey(ch)) {
                    temp = temp.children.get(ch);
                } else return false;
            }
            return temp.isEnd;
        }

        public boolean startsWith(String prefix) {
            TrieNode temp = this.root;
            for (Character ch : prefix.toCharArray()) {
                if (!temp.children.containsKey(ch)) {
                    return false;
                }
                temp = temp.children.get(ch);
            }
            return true;
        }
    }

    public static List<String> findWords(char[][] board, String[] words) {
        int row = board.length;
        int col = board[0].length;
        Set<String> result = new HashSet<>();
        Trie trie = buildTrie(words);
        TrieNode root = trie.root;
        HashSet<String> visited = new HashSet<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                helper(board, "", i, j, visited, root, result);
            }
        }
        return new ArrayList<>(result);
    }

    public static void helper(char[][] board, String word, int row, int col, HashSet<String> visited, TrieNode root, Set<String> resultList) {
        boolean rowInBounds = row >= 0 && row < board.length;
        boolean colInBounds = col >= 0 && col < board[0].length;
        if (!rowInBounds || !colInBounds) return;
        if(root.children.get(board[row][col]) == null) return;
        String cell = row + "," + col;
        if (visited.contains(cell)) return;
        visited.add(cell);
        root = root.children.get(board[row][col]);
        word += board[row][col];
        if(root.isEnd){
            resultList.add(word);
        }
        helper(board, word, row-1, col, visited, root, resultList);
        helper(board, word, row + 1, col, visited, root, resultList);
        helper(board, word, row, col-1, visited, root, resultList);
        helper(board, word, row, col + 1, visited, root, resultList);
        visited.remove(cell);
    }

    public static Trie buildTrie(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        return trie;
    }

    public static void main(String[] args) {
        char[][] board = {{'a', 'a'}};
        String[] words = {"aaa"};
        System.out.println(findWords(board, words));
    }
}

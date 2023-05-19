package Blind75.Tries;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {

    public static List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (exist(board, word)) {
                result.add(word);
            }
        }
        return result;
    }

    public static boolean exist(char[][] board, String word) {
        Set<String> visited = new HashSet<>();
        int rowSize = board.length;
        int colSize = board[0].length;
        for (int r = 0; r < rowSize; r++) {
            for (int c = 0; c < colSize; c++) {
                if (helper(board, word, r, c, visited, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean helper(char[][] board, String word, int row, int col, Set<String> visited, int index) {
        boolean rowInBounds = row >= 0 && row < board.length;
        boolean colInBounds = col >= 0 && col < board[0].length;
        if (!rowInBounds || !colInBounds) return false;
        if (board[row][col] != word.charAt(index)) return false;
        String cell = row + "," + col;
        if (visited.contains(cell)) return false;
        visited.add(cell);
        if (index == word.length() - 1) return true;
        boolean result = helper(board, word, row - 1, col, visited, index + 1);
        result |= helper(board, word, row + 1, col, visited, index + 1);
        result |= helper(board, word, row, col - 1, visited, index + 1);
        result |= helper(board, word, row, col + 1, visited, index + 1);
        visited.remove(cell);
        return result;
    }

    public static void main(String[] args) {
        char[][] board = {{'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain"};
        System.out.println(findWords(board, words));
    }
}

package Blind75.Arrays;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public static boolean isValidSudoku(char[][] board) {
        if (isBoardEmpty(board)) return true;
        return isValidVertically(board) && isValidHorizontally(board) && isSubBoxesValid(board);
    }

    public static boolean isSubBoxesValid(char[][] board) {
        // 0-2 3-5 6-8
        for (int rowSt = 0; rowSt < 9; rowSt += 3) {
            for (int colSt = 0; colSt < 9; colSt+=3) {
                Set<Character> visited = new HashSet<>();
                for (int i = rowSt; i < rowSt + 3; i++) {
                    for (int j = colSt; j < colSt + 3; j++) {
                        if (board[i][j] != '.' && visited.contains(board[i][j])) {
                            return false;
                        }
                        visited.add(board[i][j]);
                    }
                }
            }
        }
        return true;
    }

    public static boolean isBoardEmpty(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] != '.')
                    return false;
            }
        }
        return true;
    }

    public static boolean isValidVertically(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            Set<Character> visited = new HashSet<>();
            for (int j = 0; j < col; j++) {
                if (board[i][j] != '.' && visited.contains(board[i][j]))
                    return false;
                visited.add(board[i][j]);
            }
        }
        return true;
    }

    public static boolean isValidHorizontally(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < col; i++) {
            Set<Character> visited = new HashSet<>();
            for (int j = 0; j < row; j++) {
                if (board[j][i] != '.' && visited.contains(board[j][i]))
                    return false;
                visited.add(board[j][i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board =
                {{'5' , '3' , '.' , '.' , '7' , '.' , '.' , '.' , '.'},
                        {'6' , '.' , '.' , '1' , '9' , '5' , '.' , '.' , '.'},
                        {'.' , '9' , '8' , '.' , '.' , '.' , '.' , '6' , '.'},
                        {'8' , '.' , '.' , '.' , '6' , '.' , '.' , '.' , '3'},
                        {'4' , '.' , '.' , '8' , '.' , '3' , '.' , '.' , '1'},
                        {'7' , '.' , '.' , '.' , '2' , '.' , '.' , '.' , '6'},
                        {'.' , '6' , '.' , '.' , '.' , '.' , '2' , '8' , '.'},
                        {'.' , '.' , '.' , '4' , '1' , '9' , '.' , '.' , '5'},
                        {'.' , '.' , '.' , '.' , '8' , '.' , '.' , '7' , '9'}};
        System.out.println(isValidSudoku(board));
    }
}

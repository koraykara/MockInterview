package Blind75.Matrix;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {

    // Time: O(n*m)
    // Space: O(n+m)
    public static void setZeroes(int[][] matrix) {
        Set<String> visited = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                String cell = i + "," + j;
                if (matrix[i][j] == 0) {
                    if (!visited.contains(cell)) {
                        setVerticalZero(matrix, i, j, visited);
                        setHorizontalZero(matrix, i, j, visited);
                    }
                    visited.add(cell);
                }
            }
        }
    }

    public static void setVerticalZero(int[][] matrix, int row, int col, Set<String> visited) {
        String currentCell = row + "," + col;
        for (int r = 0; r < matrix.length; r++) {
            if (!(r + "," + col).equals(currentCell) && matrix[r][col] != 0) {
                matrix[r][col] = 0;
                visited.add(r + "," + col);
            }
        }
    }

    public static void setHorizontalZero(int[][] matrix, int row, int col, Set<String> visited) {
        String currentCell = row + "," + col;
        for (int c = 0; c < matrix[0].length; c++) {
            if (!(row + "," + c).equals(currentCell) && matrix[row][c] != 0) {
                matrix[row][c] = 0;
                visited.add(row + "," + c);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        System.out.println(Arrays.deepToString(matrix));
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}

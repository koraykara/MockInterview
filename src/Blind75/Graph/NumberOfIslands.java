package Blind75.Graph;

import java.util.HashSet;

public class NumberOfIslands {

    public static int numIslands(char[][] grid) {
        int rowSize = grid.length;
        int colSize = grid[0].length;
        HashSet<String> visited = new HashSet<String>();
        int count = 0;
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (explore(grid, i, j, visited)) {
                    count += 1;
                }
            }
        }
        return count;
    }

    public static boolean explore(char[][] grid, int row, int col, HashSet<String> visited) {
        boolean rowInBounds = row >= 0 && row < grid.length;
        boolean colInBounds = col >= 0 && col < grid[0].length;
        if (!rowInBounds || !colInBounds) return false;
        if (grid[row][col] == '0') return false;
        String node = row + "," + col;
        if (visited.contains(node)) return false;
        visited.add(node);
        explore(grid, row + 1, col, visited);
        explore(grid, row - 1, col, visited);
        explore(grid, row, col + 1, visited);
        explore(grid, row, col - 1, visited);
        return true;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
                };
        System.out.println(numIslands(grid));
    }
}

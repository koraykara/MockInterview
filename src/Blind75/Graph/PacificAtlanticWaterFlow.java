package Blind75.Graph;

import AlgoExpertQuestions.Medium.BreathFirstSearch;
import org.w3c.dom.ls.LSInput;

import java.util.*;

public class PacificAtlanticWaterFlow {

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rowSize = heights.length;
        int colSize = heights[0].length;
        List<List<Integer>> result = new ArrayList<>();
        boolean[][] pacificCells = new boolean[rowSize][colSize];
        boolean[][] atlanticCells = new boolean[rowSize][colSize];
        for (int c = 0; c < colSize; c++) {
            helper(heights, 0, c, pacificCells);
            helper(heights, rowSize-1, c, atlanticCells);
        }
        for (int r = 0; r < rowSize; r++) {
            helper(heights, r, 0, pacificCells);
            helper(heights, r, colSize-1, atlanticCells);
        }
        for(int i=0;i<rowSize;i++){
            for(int j=0;j<colSize;j++){
                if(pacificCells[i][j] && atlanticCells[i][j]){
                    result.add(new ArrayList<>(Arrays.asList(i,j)));
                }
            }
        }
        return result;
    }

    public static void helper(int[][] heights, int row, int col, boolean[][] visitedCells) {
        boolean rowInBounds = row >= 0 && row < heights.length;
        boolean colInBounds = col >= 0 && col < heights[0].length;
        if (!rowInBounds || !colInBounds) return;
        if(visitedCells[row][col]) return;
        visitedCells[row][col] = true;
        if (row - 1 >= 0 && heights[row][col] <= heights[row - 1][col])
            helper(heights, row - 1, col, visitedCells);
        if (row + 1 < heights.length && heights[row][col] <= heights[row + 1][col])
            helper(heights, row + 1, col, visitedCells);
        if (col - 1 >= 0 && heights[row][col] <= heights[row][col - 1])
            helper(heights, row, col - 1, visitedCells);
        if (col + 1 < heights[0].length && heights[row][col] <= heights[row][col + 1])
            helper(heights, row, col + 1, visitedCells);
    }

    public static void main(String[] args) {
        int[][] heights = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        System.out.println(pacificAtlantic(heights));
    }
}

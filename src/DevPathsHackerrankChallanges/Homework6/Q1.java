package DevPathsHackerrankChallanges.Homework6;

import Others.LeetcodePeekIndexInMountainArray;

import java.util.*;

public class Q1 {

    public static List<Integer> onesGroups(List<List<Integer>> grid, List<Integer> queries) {
        // Write your code here.
        int row = grid.size();
        int column = grid.get(0).size();
        Set<String> visited = new HashSet<>();
        List<Integer> queriesFromGrid = new ArrayList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                int size = sizeOfRiver(grid, i, j, visited);
                if(size != 0){
                    queriesFromGrid.add(size);
                }
            }
        }
        System.out.println(queriesFromGrid);
        System.out.println(queries);
        return createResult(queriesFromGrid, queries);
    }

    public static List<Integer> createResult(List<Integer> queriesFromGrid, List<Integer> queries){
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for(int val: queries){
            map.put(val, 0);
        }
        for(int val: queriesFromGrid){
            if(map.containsKey(val)) {
                map.put(val, map.get(val) + 1);
            }
        }
        for(int val: queries){
            result.add(map.get(val));
        }
        return result;
    }

    public static int sizeOfRiver(List<List<Integer>> grid, int row, int col, Set<String> visited){
        boolean rowInBounds = row >= 0 && row < grid.size();
        boolean colInBounds = col >= 0 && col < grid.get(0).size();
        if(!rowInBounds || !colInBounds) return 0;
        if(grid.get(row).get(col) == 0) return 0;
        String pos = row + "," + col;
        if(visited.contains(pos)) return 0;
        visited.add(pos);
        int size = 1;
        size += sizeOfRiver(grid, row-1, col, visited);
        size += sizeOfRiver(grid, row+1, col, visited);
        size += sizeOfRiver(grid, row, col-1, visited);
        size += sizeOfRiver(grid, row, col+1, visited);
        return size;
    }

    public static void main(String[] args) {
        List<List<Integer>> grid = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        row.add(1);
        row.add(1);
        row.add(1);
        row.add(1);
        row.add(1);
        row.add(1);
        row.add(1);
        row.add(1);
        row.add(1);
        row.add(1);
        grid.add(row);
        row = new ArrayList<>();
        row.add(1);
        row.add(1);
        row.add(1);
        row.add(1);
        row.add(0);
        row.add(0);
        row.add(0);
        row.add(0);
        row.add(0);
        row.add(0);
        grid.add(row);
        row = new ArrayList<>();
        row.add(1);
        row.add(1);
        row.add(1);
        row.add(0);
        row.add(0);
        row.add(0);
        row.add(0);
        row.add(1);
        row.add(1);
        row.add(1);
        grid.add(row);
        row = new ArrayList<>();
        row.add(1);
        row.add(1);
        row.add(0);
        row.add(0);
        row.add(1);
        row.add(0);
        row.add(0);
        row.add(1);
        row.add(1);
        row.add(1);
        grid.add(row);
        row = new ArrayList<>();
        row.add(1);
        row.add(0);
        row.add(1);
        row.add(0);
        row.add(0);
        row.add(1);
        row.add(1);
        row.add(0);
        row.add(0);
        row.add(0);
        grid.add(row);
        row = new ArrayList<>();
        row.add(0);
        row.add(0);
        row.add(0);
        row.add(0);
        row.add(0);
        row.add(0);
        row.add(0);
        row.add(0);
        row.add(0);
        row.add(0);
        grid.add(row);
        row = new ArrayList<>();
        row.add(0);
        row.add(0);
        row.add(0);
        row.add(0);
        row.add(0);
        row.add(0);
        row.add(0);
        row.add(0);
        row.add(0);
        row.add(0);
        grid.add(row);
        row = new ArrayList<>();
        row.add(1);
        row.add(1);
        row.add(1);
        row.add(1);
        row.add(1);
        row.add(1);
        row.add(1);
        row.add(1);
        row.add(1);
        row.add(1);
        grid.add(row);
        row = new ArrayList<>();
        row.add(0);
        row.add(0);
        row.add(0);
        row.add(0);
        row.add(0);
        row.add(0);
        row.add(0);
        row.add(0);
        row.add(0);
        row.add(0);
        grid.add(row);
        row = new ArrayList<>();
        row.add(1);
        row.add(1);
        row.add(1);
        row.add(1);
        row.add(1);
        row.add(1);
        row.add(1);
        row.add(1);
        row.add(1);
        row.add(1);
        grid.add(row);

        List<Integer> queries = new ArrayList<>();
        queries.add(1);
        queries.add(10);
        queries.add(20);
        queries.add(6);
        queries.add(2);

        System.out.println(onesGroups(grid, queries));
    }
}

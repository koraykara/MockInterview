package DevPathsHackerrankChallanges.Homework4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q1 {

    public static int maxGameScore(List<Integer> cell) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        return jump(cell, 0, 0, memo);
    }

    public static int jump(List<Integer> cell, int index, int max, HashMap<Integer, Integer> memo){
        if(memo.containsKey(index)) return memo.get(index);
        if(index >= cell.size()){
            max += -Integer.MAX_VALUE;
            memo.put(index, max);
            return max;
        }
        else if(index == cell.size()-1) {
            max += cell.get(index);
            return max;
        }
        else {
            max += cell.get(index) + Math.max(jump(cell, index + 1, max, memo), jump(cell, index + 3, max, memo));
            memo.put(index, max);
            if(index >= cell.size()) return -Integer.MAX_VALUE;

        }
        return max;
    }

    public static void main(String[] args) {
        List<Integer> cell = new ArrayList<>();
        cell.add(0);
        cell.add(-100);
        cell.add(-100);
        cell.add(-1);
        cell.add(0);
        cell.add(-1);
        System.out.println(maxGameScore(cell));
    }
}

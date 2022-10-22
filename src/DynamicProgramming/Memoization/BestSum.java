package DynamicProgramming.Memoization;

import java.util.ArrayList;
import java.util.HashMap;

public class BestSum {


    // Brute force:
    // time: O(n^m * m)
    // space: O(m^^2)

    // memoization:
    // time: O(m^2 * n)
    // space: O(m^2)
    public static ArrayList<Integer> howSum(int targetSum, int[] numbers, HashMap<Integer, ArrayList<Integer>> memo){
        if(memo.containsKey(targetSum)) return memo.get(targetSum);
        if(targetSum == 0) return new ArrayList<>();
        if(targetSum < 0) return null;
        ArrayList<Integer> shortestCombination = null;
        for(int num: numbers){
            int remainder = targetSum - num;
            ArrayList<Integer> remainderCombination = howSum(remainder, numbers, memo);
            if(remainderCombination != null){
                ArrayList<Integer> combination = new ArrayList<>(remainderCombination);
                combination.add(num);
                if(shortestCombination == null || combination.size() < shortestCombination.size()){
                    shortestCombination = combination;
                }
            }
        }
        memo.put(targetSum, shortestCombination);
        return shortestCombination;
    }

    public static void main(String[] args) {
        System.out.println(howSum(100, new int[]{1,2,5,25}, new HashMap<>()));
    }
}

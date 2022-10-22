package DynamicProgramming.Memoization;

import java.util.ArrayList;
import java.util.HashMap;

public class HowSum {

    // Brute force ->time: O(n^m * m), space: O(m)
    // memoized: O(n*m*m) = O(n*m^2), space: O(m^2)
    public static ArrayList<Integer> howSum(int targetSum, int[] numbers, HashMap<Integer, ArrayList<Integer>> memo){
        if(memo.containsKey(targetSum)) return memo.get(targetSum);
        if(targetSum == 0) return new ArrayList<>();
        if(targetSum < 0) return null;
        for(int num: numbers){
            int remainder = targetSum - num;
            ArrayList<Integer> remainderResult = howSum(remainder, numbers, memo);
            if(remainderResult != null){
                remainderResult.add(num);
                memo.put(targetSum, remainderResult);
                return memo.get(targetSum);
            }
        }
        memo.put(targetSum, null);
        return null;
    }

    public static void main(String[] args) {
        System.out.println(howSum(300, new int[]{7,14}, new HashMap<>()));
    }
}

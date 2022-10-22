package DynamicProgramming.Memoization;

import java.util.HashMap;

public class CanSum {

    // with brute force: O(n^m) time, O(m) space,
    // by uising memo, O(m*n) time, O(m) space
    public static boolean canSum(int targetSum, int[] numbers, HashMap<Integer, Boolean> memo){
        if(memo.containsKey(targetSum)) return memo.get(targetSum);
        if(targetSum == 0) return true;
        if(targetSum < 0) return false;
        for(int num: numbers){
            int remainder = targetSum - num;
            if(canSum(remainder, numbers, memo)){
                memo.put(targetSum, true);
                return true;
            }
        }
        memo.put(targetSum, false);
        return false;
    }

    public static void main(String[] args) {
        int[] numbers = {7,393};
        System.out.println(canSum(400, numbers, new HashMap<>()));
    }
}

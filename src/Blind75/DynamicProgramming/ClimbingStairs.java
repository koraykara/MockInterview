package Blind75.DynamicProgramming;

import java.util.HashMap;

public class ClimbingStairs {

    public static int climbStairs(int n){
        return helperClimb(n, new HashMap<>());
    }

    public static int helperClimb(int n, HashMap<Integer, Integer> memo){
        if(memo.containsKey(n)) return memo.get(n);
        if(n == 0) return 1;
        if(n <= 0) return 0;
        memo.put(n, helperClimb(n-1, memo) + helperClimb(n-2, memo));
        return memo.get(n);
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(60));
    }
}

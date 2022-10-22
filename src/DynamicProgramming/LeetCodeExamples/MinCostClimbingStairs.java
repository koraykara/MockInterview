package DynamicProgramming.LeetCodeExamples;

import java.util.HashMap;

public class MinCostClimbingStairs {

    public static int minCostClimbingStairs(int[] cost) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        return Math.min(calculateMinCost(cost, 0, memo), calculateMinCost(cost,1, memo));
    }

    public static int calculateMinCost(int[] cost, int index, HashMap<Integer, Integer> memo){
        if(memo.containsKey(index)) return memo.get(index);
        if(index >= cost.length) return 0;
        int oneClimbCost = cost[index] + calculateMinCost(cost, index+1, memo);
        int twoClimbCost = cost[index] + calculateMinCost(cost, index+2, memo);
        int result = Math.min(oneClimbCost, twoClimbCost);
        memo.put(index, result);
        return result;
    }

    public static void main(String[] args) {
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        System.out.println(minCostClimbingStairs(cost));
    }
}

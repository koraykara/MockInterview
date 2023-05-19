package Blind75.DynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CoinChangeBottomUp {

    public static int coinChange(int[] coins, int amount) {
        if(coins.length == 1 && coins[0] == 1) return amount;
        List<Integer> result = helper(coins, amount, new HashMap<>());
        if(result == null) return -1;
        return result.size();
    }

    public static List<Integer> helper(int[] coins, int amount, HashMap<Integer, List<Integer>> memo){
        if(memo.containsKey(amount)) return memo.get(amount);
        if(amount == 0) return new ArrayList<>();
        if(amount < 0) return null;
        List<Integer> shortestCombination = null;
        for(int coin: coins){
            int remainder = amount - coin;
            List<Integer> oneOfTheCombination = helper(coins, remainder, memo);
            if(oneOfTheCombination != null){
                List<Integer> combination = new ArrayList<>(oneOfTheCombination);
                combination.add(coin);
                if(shortestCombination == null || combination.size() < shortestCombination.size()){
                    shortestCombination = combination;
                }
            }
        }
        memo.put(amount, shortestCombination);
        return shortestCombination;
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 5;
        System.out.println(coinChange(coins, amount));
    }
}

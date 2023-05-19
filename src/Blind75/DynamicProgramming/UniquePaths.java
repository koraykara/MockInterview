package Blind75.DynamicProgramming;

import java.util.HashMap;

public class UniquePaths {

    public static int uniquePaths(int m, int n) {
        return helper(m, n, new HashMap<String, Integer>());
    }

    public static int helper(int m, int n, HashMap<String,Integer> memo){
        if(memo.containsKey(m + "," + n)) return memo.get(m + "," + n);
        if(m == 0 || n == 0) return 0;
        if(m == 1 || n == 1) return 1;
        int countRightUniqueWays = helper(m-1, n, memo);
        int countDownUniqueWays = helper(m, n-1, memo);
        memo.put(m + "," + n, countRightUniqueWays + countDownUniqueWays);
        return countRightUniqueWays + countDownUniqueWays;
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3,7));
    }
}

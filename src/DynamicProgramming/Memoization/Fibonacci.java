package DynamicProgramming.Memoization;

import java.util.HashMap;

public class Fibonacci {

    // O(n) time
    // O(n) space
    //(without memoization the complexity is O(2^n))
    public static int fib(int n, HashMap<Integer, Integer> memo){
        if(memo.containsKey(n)) return memo.get(n);
        if(n<=2) return 1;
        memo.put(n, fib(n-1, memo) + fib(n-2, memo));
        return memo.get(n);
    }

    public static void main(String[] args) {

        System.out.println(fib(20, new HashMap<>()));
    }
}

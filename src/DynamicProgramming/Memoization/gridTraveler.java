package DynamicProgramming.Memoization;

import java.util.HashMap;

public class gridTraveler {

    //(without memoization O(2^(n+m) time complexity)) --> with memoization O(m*n) time complexity
    // O(n+m) complexity --> same with using memo
    public static long gridTraveler(long m, long n, HashMap<String, Long> memo){
        String key = Long.toString(m) + "," + Long.toString(n);
        if(memo.containsKey(key)) return memo.get(key);
        if(m == 1 || n == 1) return 1;
        if(m == 0 || n == 0) return 0;
        memo.put(key, gridTraveler(m-1, n, memo) + gridTraveler(m, n-1, memo));
        return memo.get(key);
    }

    public static void main(String[] args) {
        System.out.println(gridTraveler(18,18, new HashMap<>()));
    }
}

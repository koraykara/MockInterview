package DynamicProgramming.HackerRankExamples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CoinChange {

    // n = 4, c = {1,2,3}
    public static long getWays(int n, List<Long> c) {
        return helper(n,c,0,new HashMap<>());
    }

    public static long helper(int n, List<Long> c,int index,HashMap<String, Long> memo){
        String key = n + "-" + index;
        if(memo.containsKey(key)) return memo.get(key);
        if(n == 0) return 1;
        if(n<0) return 0;
        long countWays = 0;
        for(int i=index;i<c.size();i++){
            int remainder = (int) (n - c.get(i));
            countWays += helper(remainder, c,i, memo);
        }
        memo.put(key, countWays);
        //System.out.println(key + " --> " + countWays);
        System.out.println(memo);
        return countWays;
    }

    public static void main(String[] args) {
        List<Long> c = new ArrayList<>();
        long[] arr = {1,2,3};
        for(long num: arr){
            c.add(num);
        }
        System.out.println(getWays(4, c));
        //System.out.println(c);
    }
}

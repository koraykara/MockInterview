package Blind75.DynamicProgramming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class DecodeWays {

    public static int numDecodings(String s) {
        return helper(s, new HashMap<>());
    }

    public static int helper(String s, HashMap<String, Integer> memo){
        if(memo.containsKey(s)) return memo.get(s);
        if(s.length() == 1 && s.charAt(0) == '0'){
            memo.put(s, 0);
            return 0;
        }
        if(s.isEmpty() || s.length() == 1){
            memo.put(s, 1);
            return 1;
        }
        if(s.charAt(0) == '0'){
            memo.put(s, 0);
            return 0;
        }
        String oneDecoding = s.substring(0,1);
        String twoDecoding = s.substring(0,2);
        int numOfOneDecoding = 0;
        int numOfTwoDecoding = 0;
        if(isValidDecoding(oneDecoding))
            numOfOneDecoding += helper(s.substring(1), memo);
        if(isValidDecoding(twoDecoding))
            numOfTwoDecoding += helper(s.substring(2), memo);
        memo.put(s, numOfOneDecoding + numOfTwoDecoding);
        return numOfOneDecoding + numOfTwoDecoding;
    }

    public static boolean isValidDecoding(String s){
        return !s.isEmpty() && (Integer.parseInt(s) >= 1 && Integer.parseInt(s) <= 26);
    }

    public static void main(String[] args) {
        String s = "2263";
        System.out.println(numDecodings(s));
    }
}

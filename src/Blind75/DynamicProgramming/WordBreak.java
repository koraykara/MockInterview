package Blind75.DynamicProgramming;

import java.util.*;

public class WordBreak {

    public static boolean wordBreak(String s, List<String> wordDict) {
        return helper(s, wordDict, new HashMap<>());
    }

    public static boolean helper(String s, List<String> wordDict, HashMap<String, Boolean> memo){
        if(memo.containsKey(s)) return memo.get(s);
        if(s.equals("")) return true;
        for(String word: wordDict){
            if(s.indexOf(word) == 0){
                String remainder = s.substring(word.length());
                if(helper(remainder, wordDict, memo)){
                    memo.put(s, true);
                    return true;
                }
            }
        }
        memo.put(s, false);
        return false;
    }

    public static void main(String[] args) {
        String s = "catsandog";
        List<String> wordDict = new ArrayList<>(Arrays.asList("cats","dog","sand","and","cat"));
        System.out.println(wordBreak(s, wordDict));
    }
}

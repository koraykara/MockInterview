package DynamicProgramming.Memoization;

import java.util.ArrayList;
import java.util.HashMap;

public class CountConstruct {

    // m = target.length
    // n = wordBank.length
    // Brute force:
    // time: O(n^m * m),
    // space: O(m^2)

    // memoization:
    // time: O(n * m^2)
    // space: O(m^2)
    public static int countConstruct(String target, ArrayList<String> wordBank, HashMap<String, Integer> memo){
        if(memo.containsKey(target)) return memo.get(target);
        if(target.length() == 0) return 1;
        int count = 0;
        for(String word: wordBank){
            if(target.indexOf(word) == 0){
                String numOfWaysForRest = target.substring(word.length());
                count += countConstruct(numOfWaysForRest, wordBank, memo);
            }
        }
        memo.put(target, count);
        return count;
    }

    public static void main(String[] args) {
        String target = "purple";
        ArrayList<String> wordBank = new ArrayList<>();
        wordBank.add("purp");
        wordBank.add("p");
        wordBank.add("ur");
        wordBank.add("le");
        wordBank.add("purpl");

        System.out.println(countConstruct(target, wordBank, new HashMap<>()));


        wordBank = new ArrayList<>();
        wordBank.add("e");
        wordBank.add("ee");
        wordBank.add("eee");
        wordBank.add("eeee");
        wordBank.add("eeeee");
        wordBank.add("eeeeee");
        System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", wordBank, new HashMap<>()));

    }
}

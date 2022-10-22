package DynamicProgramming.Memoization;

import java.util.ArrayList;
import java.util.HashMap;

public class CanConstruct {

    // Brute force:
    // time: O(n^m * m),
    // space: O(m^2)

    // memoization:
    // time: O(n * m^2)
    // space: O(m^2)
    public static boolean canConstruct(String target, ArrayList<String> wordBank, HashMap<String, Boolean> memo){
        if(memo.containsKey(target)) return memo.get(target);
        if(target.length() == 0) return true;
        for(String word: wordBank){
            if(target.indexOf(word) == 0){
                String suffix = target.substring(word.length());
                if(canConstruct(suffix, wordBank, memo)){
                    memo.put(target, true);
                    return true;
                }
            }
        }
        memo.put(target, false);
        return false;
    }

    public static void main(String[] args) {
        String target = "skateboard";
        ArrayList<String> wordBank = new ArrayList<>();
        wordBank.add("bo");
        wordBank.add("rd");
        wordBank.add("ate");
        wordBank.add("t");
        wordBank.add("ska");
        wordBank.add("sk");
        wordBank.add("boar");
        System.out.println(canConstruct(target, wordBank, new HashMap<>()));

        wordBank = new ArrayList<>();
        wordBank.add("e");
        wordBank.add("ee");
        wordBank.add("eee");
        wordBank.add("eeee");
        wordBank.add("eeeee");
        wordBank.add("eeeeee");
        System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", wordBank, new HashMap<>()));

    }
}

package DynamicProgramming.Memoization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllConstruct {

    public static List<List<String>> allConstruct(String target, List<String> wordBank){
        if(target.length() == 0) return new ArrayList<>(Arrays.asList(new ArrayList<>()));
        List<List<String>> targetWays = new ArrayList<>();
        for(String word: wordBank){
            if(target.indexOf(word) == 0){
                String suffix = target.substring(word.length());
                List<List<String>> suffixWays = allConstruct(suffix, wordBank);
                for (List<String> suffixWay : suffixWays) {
                    ArrayList<String> temp = new ArrayList<>(suffixWay);
                    temp.add(word);
                    targetWays.add(temp);
                }
            }
        }
        return targetWays;
    }

    public static void main(String[] args) {
        String target = "purple";
        ArrayList<String> wordBank = new ArrayList<>();
        wordBank.add("purp");
        wordBank.add("p");
        wordBank.add("ur");
        wordBank.add("le");
        wordBank.add("purpl");

        System.out.println(allConstruct(target, wordBank));


    }
}

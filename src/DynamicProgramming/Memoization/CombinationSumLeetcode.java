package DynamicProgramming.Memoization;

import java.util.*;

public class CombinationSumLeetcode {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        return helper(candidates, target, new HashMap<>());
    }

    public static List<List<Integer>> helper(int[] candidates, int target, HashMap<Integer, List<List<Integer>>> memo){
        if(memo.containsKey(target)) return memo.get(target);
        if(target == 0) return new ArrayList<>(Arrays.asList(new ArrayList<>()));
        if(target < 0) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> collection = new ArrayList<>();
        for(int candidate: candidates){
            int remainder = target - candidate;
            List<List<Integer>> remainderPath = combinationSum(candidates, remainder);
            for(List<Integer> remainders: remainderPath){
                List<Integer> temp = new ArrayList<>(remainders);
                temp.add(candidate);
                Collections.sort(temp);
                if(!collection.contains(temp)){
                    result.add(temp);
                    collection.add(temp);
                }
            }
        }
        memo.put(target, result);
        return result;
    }

    public static void main(String[] args) {
        int target = 7;
        int[] candidates = {5,3,4};

        System.out.println(combinationSum(candidates,target));

        //System.out.println(combinationSum(candidates, target));
    }
}

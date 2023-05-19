package Blind75.DynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (target == 0) return new ArrayList<>(List.of(new ArrayList<>()));
        if (target < 0) return null;
        List<List<Integer>> result = new ArrayList<>();
        for (int candidate : candidates) {
            int remainder = target - candidate;
            List<List<Integer>> remainderPath = combinationSum(candidates, remainder);
            if (remainderPath != null){
                List<List<Integer>> copy = new ArrayList<>(remainderPath);
                for(List<Integer> list: copy){
                    list.add(candidate);
                }
                for(List<Integer> list: copy){
                    Collections.sort(list);
                    if(!result.contains(list)){
                        result.add(list);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(combinationSum(candidates, target));
    }
}

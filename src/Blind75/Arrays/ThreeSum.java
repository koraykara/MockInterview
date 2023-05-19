package Blind75.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        HashMap<Integer, Integer> visited = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length;i++){
            visited.put(nums[i], i);
        }
        for(int i=0;i<nums.length;i++){
            int targetSum = -nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int complement = targetSum - nums[j];
                if (visited.containsKey(complement) && visited.get(complement) > j) {
                    List<Integer> addedList = Arrays.asList(nums[i], nums[j], complement);
                    if(!result.contains(addedList))
                        result.add(addedList);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }
}

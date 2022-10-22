package DynamicProgramming.LeetCodeExamples;

import java.util.HashMap;

public class HouseRobber {

    public static int rob(int[] nums) {
        return robMaxAmountOfMoney(nums, 0, new HashMap<>());
    }

    public static int robMaxAmountOfMoney(int[] nums, int index, HashMap<Integer, Integer> memo){
        if(memo.containsKey(index)) return memo.get(index);
        if(index >= nums.length) return 0;
        int totalRob = 0;
        for(int i=index;i<nums.length;i++){
            int maxAmount = nums[i] + robMaxAmountOfMoney(nums, i+2, memo);
            if(totalRob < maxAmount) totalRob = maxAmount;
        }
        memo.put(index, totalRob);
        return totalRob;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,1,2};
        System.out.println(rob(nums));
    }
}

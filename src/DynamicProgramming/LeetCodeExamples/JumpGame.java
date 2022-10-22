package DynamicProgramming.LeetCodeExamples;

import java.util.HashMap;

public class JumpGame {

    public static boolean canJump(int[] nums) {
        HashMap<Integer, Boolean> memo = new HashMap<>();
        return jump(nums, 0, memo);
    }

    public static boolean jump(int[] nums, int index, HashMap<Integer, Boolean> memo){
        if(memo.containsKey(index)) return memo.get(index);
        if(index == nums.length -1 ){
            memo.put(index, true);
            return true;
        }
        if(index >= nums.length){
            memo.put(index, false);
            return false;
        }
        for(int i=1;i<=nums[index];i++){
            if(jump(nums, index+i, memo)){
                memo.put(index, true);
                return true;
            }
        }
        memo.put(index, false);
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,0,5};
        System.out.println(canJump(nums));
    }
}

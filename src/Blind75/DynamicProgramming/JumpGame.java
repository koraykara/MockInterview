package Blind75.DynamicProgramming;

import javax.management.timer.TimerNotification;
import java.util.Arrays;
import java.util.HashMap;

public class JumpGame {

    // O(n) solution ama nedense en son test case de takıldı
    public static boolean canJump(int[] nums) {
        return helper(nums, 0, new HashMap<>());
    }

    public static boolean helper(int[] nums, int index, HashMap<Integer, Boolean> memo) {
        if (memo.containsKey(index)) return memo.get(index);
        if (index >= nums.length) {
            memo.put(index, false);
            return false;
        }
        if (index == nums.length - 1) {
            memo.put(index, true);
            return true;
        }
        for (int i = 1; i <= nums[index]; i++) {
            if (helper(nums, i + index, memo)) {
                memo.put(index, true);
                return true;
            }
        }
        memo.put(index, false);
        return false;
    }

    // O(n) solution
    public static boolean canJumpSecondSolution(int[] nums) {
        boolean[] canJumpArr = new boolean[nums.length];
        canJumpArr[nums.length - 1] = true;
        for (int i = nums.length - 2; i >= 0; i--) {
            if(nums[i] == 0){
                canJumpArr[i] = false;
            }
            else {
                for(int j=1;j<=nums[i];j++){
                    if (canJumpArr[i + j]) {
                        canJumpArr[i] = true;
                        break;
                    }
                }
                if(!canJumpArr[i]){
                    int maxReach = (nums[i] + i) - (nums.length-1);
                    if(maxReach >= 0){
                        canJumpArr[i] = true;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(canJumpArr));
        return canJumpArr[0];
    }

    public static boolean canJumpThirdSolution(int[] nums) {
        if(nums[0] == 0 && nums.length != 1) return false;
        int len = nums.length;
        boolean[] table = new boolean[len];
        table[0] = true;
        for(int i=0;i<len;i++){
            for(int jump=1;jump <= nums[i];jump++){
                if(i + jump < len){
                    table[i + jump] = true;
                }
            }
        }
        System.out.println(Arrays.toString(table));
        boolean result = true;
        for(boolean val: table){
            result &= val;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,1,0};
        System.out.println(canJumpThirdSolution(nums));
    }
}

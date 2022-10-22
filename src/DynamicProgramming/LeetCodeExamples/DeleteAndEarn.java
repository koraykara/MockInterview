package DynamicProgramming.LeetCodeExamples;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class DeleteAndEarn {

    public static int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> map = buildHashMap(nums);
        HashMap<Integer, Integer> memo = new HashMap<>();
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int[] setNum = new int[set.size()];
        int i=0;
        for(int val: set){
            setNum[i++] = val;
        }
        Arrays.sort(setNum);
        return helper(setNum, 0, map, memo);
    }

    public static int helper(int[] nums, int index, HashMap<Integer, Integer> map, HashMap<Integer,Integer> memo){
        if(memo.containsKey(index)) return memo.get(index);
        if(index >= nums.length) return 0;
        int totalEarn = 0;
        for (int i=index;i<nums.length;i++) {
            int idx = i+1;
            if(i+1 < nums.length && nums[i+1] == nums[i]+1) idx++;
            int maxEarn = nums[i] * map.get(nums[i]) + helper(nums,idx,map, memo);
            if(maxEarn > totalEarn) totalEarn = maxEarn;
        }
        memo.put(index, totalEarn);
        return totalEarn;
    }

    public static HashMap<Integer, Integer> buildHashMap(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, 0);
        }
        for (int num : nums) {
            map.put(num, map.get(num)+1);
        }
        return map;
    }

    public static void main(String[] args) {
        int[] nums = {12,32,93,17,100,72,40,71,37,92,58,34,29,78,11,84,77,90,92,35,12,5,27,92,91,23,65,91,85,14,42,28,80,85,38,71,62,82,66,3,33,33,55,60,48,78,63,11,20,51,78,42,37,21,100,13,60,57,91,53,49,15,45,19,51,2,96,22,32,2,46,62,58,11,29,6,74,38,70,97,4,22,76,19,1,90,63,55,64,44,90,51,36,16,65,95,64,59,53,93};
        System.out.println(deleteAndEarn(nums));
    }
}

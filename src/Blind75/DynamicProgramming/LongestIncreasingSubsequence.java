package Blind75.DynamicProgramming;

import java.util.*;

public class LongestIncreasingSubsequence {

    // *********************************** Passes 41 of the test cases out of 54 *************************************************
    public static int lengthOfLISWithRecursion(int[] nums) {
        int longest = 0;
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!visited.contains(i)) {
                List<Integer> result = helper(nums, i, nums[i], new HashMap<>(), visited);
                if (result != null) {
                    longest = Math.max(longest, result.size());
                }
            }
        }
        return longest + 1;
    }

    public static List<Integer> helper(int[] nums, int index, int currentNum, HashMap<Integer, List<Integer>> memo, Set<Integer> visited) {
        if (memo.containsKey(index)) return memo.get(index);
        if (index == nums.length - 1 || index == nums.length) {
            memo.put(index, new ArrayList<>());
            return new ArrayList<>();
        }
        visited.add(index);
        List<Integer> longestPath = new ArrayList<>();
        for (int i = index + 1; i < nums.length; i++) {
            if (nums[i] > currentNum) {
                List<Integer> remainder = helper(nums, i, nums[i], memo, visited);
                if (remainder != null) {
                    List<Integer> copy = new ArrayList<>(remainder);
                    copy.add(nums[i]);
                    if (copy.size() > longestPath.size()) {
                        visited.add(i);
                        longestPath = copy;
                    }
                }
            }
        }
        memo.put(index, longestPath);
        return longestPath;
    }

    // ************************************************************************************************************************


    // Time: O(n^2)
    // Space: O(n)
    public static int lengthOfLIS(int[] nums) {
        int[] table = new int[nums.length];
        Arrays.fill(table, 1);
        return helper(nums, table);
    }

    public static int helper(int[] nums, int[] table) {
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            if (i + 1 < nums.length) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (num < nums[j]) {
                        table[i] = Math.max(table[i], 1 + table[j]);
                    }
                }
            }
        }
        System.out.println(Arrays.toString(table));
        int max = Integer.MIN_VALUE;
        for (int val : table) if (val > max) max = val;
        return max;
    }

    // With NeetCode: "https://www.youtube.com/watch?v=cjWnW0hdF1Y"
    public static int lengthOfLISShortestSolution(int[] nums) {
        int len = nums.length;
        int[] table = new int[len];
        table[0] = 1;
        int result = 1;
        for (int i = 1; i < len; i++) {
            int max = 1;
            for (int index = 0; index < i; index++) {
                if(nums[index] < nums[i]){
                    max = Math.max(max, 1 + table[index]);
                }
            }
            table[i] = max;
            result = Math.max(result, max);
        }
        System.out.println(Arrays.toString(table));
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,6,7,9,4,10,5,6};
        System.out.println(lengthOfLISShortestSolution(nums));
    }
}

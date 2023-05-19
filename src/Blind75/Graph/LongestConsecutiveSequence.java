package Blind75.Graph;

import java.util.*;

public class LongestConsecutiveSequence {

    // Bad time complexity
    // Time: O(n*log(n))
    // Space: O(n)
    public static int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        List<Integer> sorted = new ArrayList<>();
        for(int val: nums){
            if(!sorted.contains(val)){
                sorted.add(val);
            }
        }
        if(sorted.size() == 1) return 1;
        int index = 0;
        int max = 0 ;
        System.out.println(sorted);
        while (index < sorted.size()-1){
            int count = 1;
            while (index < sorted.size()-1 && sorted.get(index) + 1 == sorted.get(index+1)){
                count++;
                index++;
            }
            max = Math.max(max, count);
        }
        return max;
    }

    // Much better
    // Time: O(n + k) where n is the length of the nums array and k is the total number of consecutive elements
    // Space: O(n)
    public static int longestConsecutiveSolution2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int val : nums) set.add(val);
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(!set.contains(num+1)) {
                int count = 0;
                while (set.contains(num)) {
                    count++;
                    num -= 1;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }

    public static int longestConsecutiveSolution3(int[] nums) {
        int result = 0;
        Set<Integer> visited = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            int count = 1;
            int num = nums[i];
            while(true){
                if(visited.contains(num)){
                    count++;
                    num++;
                }
                else break;
            }
            if(result < count){
                result = count;
            }
            visited.add(nums[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        System.out.println(longestConsecutiveSolution3(nums));
    }
}

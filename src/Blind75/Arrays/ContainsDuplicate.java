package Blind75.Arrays;

import java.util.Arrays;
import java.util.HashSet;

public class ContainsDuplicate {

    // Time: O(n)
    // Space: O(n)
    /*
        By using set
     */
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> visited = new HashSet<>();
        for (int val : nums) {
            if (visited.contains(val))
                return true;
            visited.add(val);
        }
        return false;
    }

    // Time: O(n*log(n))
    // Space: O(1)
    /*
        By sorting the values
     */
    public static boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++){
            if(nums[i] == nums[i+1])
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(containsDuplicate(nums));
    }
}

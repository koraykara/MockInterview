package Blind75.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaximumProductSubarray {

    public static int maxProduct(int[] nums) {
        int maxProduct = 1;
        int minProduct = 1;
        List<Integer> numList = new ArrayList<>();
        for (int val : nums) numList.add(val);
        int result = Collections.max(numList);
        for (int i = 0; i < nums.length; i++) {
            int temp = maxProduct * nums[i];
            maxProduct = Math.max(minProduct * nums[i], maxProduct * nums[i]);
            maxProduct = Math.max(maxProduct, nums[i]);
            minProduct = Math.min(minProduct * nums[i], temp);
            minProduct = Math.min(minProduct, nums[i]);
            result = Math.max(result, maxProduct);
        }
        return result;
    }

    // Time: O(n^2)
    // Space: O(1)
    public static int maxProductBad(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= nums.length; j++) {
                List<Integer> subArray = addInRange(nums, i, j);
                int count = 1;
                for (int val : subArray) {
                    count *= val;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }

    public static List<Integer> addInRange(int[] nums, int start, int end) {
        List<Integer> subArrays = new ArrayList<>();
        for (int i = start; i < end; i++) {
            subArrays.add(nums[i]);
        }
        return subArrays;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        System.out.println(maxProduct(nums));
    }
}

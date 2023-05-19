package Blind75.Arrays;

import java.util.Arrays;

public class FindMinimumInRotatedSortedArray {


    // Time: n*log(n)
    // Space: O(1)
    public static int findMinBad(int[] nums) { // It should be log(n) according to rule of the question
        Arrays.sort(nums);
        return nums[0];
    }

    public static int findMin(int[] nums) { // It should be log(n) according to rule of the question
        if (nums.length == 1) return nums[0];
        int index = findPivot(nums, 0, nums.length-1);
        return nums[index];
    }

    public static int findPivot(int[] nums, int left, int right) {
        int mid = -1;
        while (left <= right) {
            mid = (left + right) / 2;
            if(mid-1 >= 0 && mid + 1 < nums.length && nums[mid] < nums[mid+1] && nums[mid] < nums[mid-1]) return mid;
            if(left == right) return left;
            if (nums[mid] > nums[right]) {
                left = mid+1;
            }
            else if(nums[mid] < nums[right]){
                right = mid-1;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,2};
        System.out.println(findMin(nums));
    }
}

package Blind75.Arrays;

public class MaximumSubarray {

    // Time: O(n)
    // Space: O(1)
    public static int maxSubArray(int[] nums) {
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int val: nums){
            currentSum += val;
            if(currentSum < 0){
                currentSum = 0;
            }
            else {
                if(maxSum < currentSum){
                    maxSum = currentSum;
                }
            }
        }
        return maxSum;
    }

    // Time: O(n^2)
    // Space: O(1)
    public static int maxSubArray2(int[] nums){
        if(nums.length == 1) return nums[0];
        int len = nums.length;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<len-1;i++){
            int sum = nums[i];
            max = Math.max(sum, max);
            for(int j=i+1;j<len;j++){
                sum += nums[j];
                sum = Math.max(nums[j], sum);
                if(sum > max){
                    max = sum;
                }
                if (sum < 0){
                    sum = 0;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray2(nums));
    }
}

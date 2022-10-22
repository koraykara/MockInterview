package DynamicProgramming.LeetCodeExamples;

public class MaximumSubArray {

    public static int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];
        for(int i=1;i<nums.length;i++){
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }

    public static int maxSubArraySum(int[] nums) {
        int[] temp = new int[nums.length];
        int totalSum = 0;
        for(int i=0;i<nums.length;i++){
            temp[i] = -nums[i];
            totalSum += nums[i];
        }
        if(totalSum + kadanesMax(temp) == 0)
            return kadanesMax(nums);
        return Math.max(totalSum + kadanesMax(temp), kadanesMax(nums));
    }

    public static int kadanesMax(int[] nums){
        int currentSum = nums[0];
        int maxSum = nums[0];
        int size = nums.length;
        for(int i=1;i<size;i++){
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-3,-2,-3};
        System.out.println(maxSubArraySum(nums));
    }
}

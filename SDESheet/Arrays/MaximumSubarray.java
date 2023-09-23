package SDESheet.Arrays;

public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {
        int curSum = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            curSum += num;
            max = Math.max(max, curSum);
            if(curSum < 0) curSum = 0;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }
}

package Blind75.Arrays;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    /*
    1,2,3,4
    prefix:  1,2,6,24
    postfix: 24,24,12,4
     */
    // Time: O(n)
    // Space: O(n)
    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, 1);
        int[] prefix = new int[nums.length];
        Arrays.fill(prefix, 1);
        int[] postfix = new int[nums.length];
        Arrays.fill(postfix, 1);
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i];
        }
        postfix[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            postfix[i] = nums[i] * postfix[i + 1];
        }
        System.out.println(Arrays.toString(prefix));
        System.out.println(Arrays.toString(postfix));
        res[0] = postfix[1];
        for (int i = 1; i < res.length-1; i++) {
            res[i] = prefix[i-1] * postfix[i+1];
        }
        res[res.length-1] = prefix[postfix.length-2];
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
}

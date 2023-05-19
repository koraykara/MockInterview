package Blind75.DynamicProgramming;

public class HouseRobber2 {

    public static int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        if (len == 2) return Math.max(nums[0], nums[1]);
        int[] numsExceptFirstNum = new int[nums.length - 1];
        int[] numsExceptLastNum = new int[nums.length - 1];
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i != 0)
                numsExceptFirstNum[index1++] = nums[i];
            if (i != nums.length - 1)
                numsExceptLastNum[index2++] = nums[i];
        }
        return Math.max(houseRobber1(numsExceptFirstNum), houseRobber1(numsExceptLastNum));
    }

    public static int houseRobber1(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        if (len == 2) return Math.max(nums[0], nums[1]);
        int[] table = new int[nums.length];
        table[len - 1] = nums[len - 1];
        table[len - 2] = Math.max(nums[len - 2], nums[len - 1]);
        for (int i = nums.length - 3; i >= 0; i--) {
            table[i] = Math.max(nums[i] + table[i + 2], table[i + 1]);
        }
        return table[0];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(rob(nums));
    }
}

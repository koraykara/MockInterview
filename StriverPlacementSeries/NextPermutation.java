package StriverPlacementSeries;

import java.util.Arrays;

public class NextPermutation {

    public static void nextPermutation(int[] nums) {
        int peekIndex = findPeekIndex(nums);
        if (peekIndex == -1) {
            reverseArray(nums, 0);
        } else {
            int greatedIndex = findImmediateGraterThanPeekIndex(nums, peekIndex);
            // swap elemets
            int temp = nums[peekIndex];
            nums[peekIndex] = nums[greatedIndex];
            nums[greatedIndex] = temp;
            reverseArray(nums, peekIndex+1);
        }
    }

    public static int findImmediateGraterThanPeekIndex(int[] nums, int peekIndex) {
        int len = nums.length;
        for (int i = len - 1; i >= 0; i--) {
            if(nums[i] > nums[peekIndex]){
                return i;
            }
        }
        return -1;
    }

    public static int findPeekIndex(int[] nums) {
        int peekIndex = -1;
        int len = nums.length;
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i+1] > nums[i]) {
                peekIndex = i;
                break;
            }
        }
        return peekIndex;
    }

    public static void reverseArray(int[] nums, int index) {
        int low = index;
        int high = nums.length - 1;
        while (low <= high) {
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
            low++;
            high--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}

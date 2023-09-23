package SDESheet.Arrays;

import java.util.Arrays;

public class NextPermutation {

    public static void nextPermutation(int[] nums) {
        int maxInsertionPoint = Integer.MIN_VALUE;
        int maxEndIndex = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            int insertionPoint = findInsertionPointIndex(nums, i);
            if (insertionPoint != -1) {
                if (maxInsertionPoint < insertionPoint) {
                    maxInsertionPoint = insertionPoint;
                    maxEndIndex = i;
                }
            }
        }
        if (maxInsertionPoint == Integer.MIN_VALUE) {
            reverseArray(nums);
        } else {
            swap(nums, maxInsertionPoint, maxEndIndex);
            if (maxInsertionPoint + 1 < nums.length) {
                sortFromIndex(nums, maxInsertionPoint + 1);
            }
        }
    }

    public static void reverseArray(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            swap(nums, low, high);
            low++;
            high--;
        }
    }

    public static int findInsertionPointIndex(int[] nums, int index) {
        int insertionIndex = -1;
        for (int i = index; i >= 0; i--) {
            if (nums[index] > nums[i]) {
                insertionIndex = i;
                break;
            }
        }
        return insertionIndex;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void sortFromIndex(int[] nums, int index) {
        for (int i = index; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    swap(nums, i, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 1};
        System.out.println(Arrays.toString(nums));
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}

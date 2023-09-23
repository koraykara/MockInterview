package StriverPlacementSeries;

import java.util.Arrays;

public class QuickSort {

    public static void quickSortAlgorithm(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    public static void quickSort(int[] nums, int low, int high) {
        if (low >= high) return;
        int partitionIndex = partition(nums, low, high);
        quickSort(nums, low, partitionIndex - 1);
        quickSort(nums, partitionIndex + 1, high);
    }

    /*
            [3,1,2,5,8,1,3]
            low = 3
     */
    public static int partition(int[] nums, int low, int high) {
        int i = low;
        int j = high;
        while (i < j) {
            while (nums[i] <= nums[low] && i < high) {
                i++;
            }
            while (nums[j] > nums[low] && j >= low) {
                j--;
            }
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        int temp = nums[low];
        nums[low] = nums[j];
        nums[j] = temp;
        return j;
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        quickSortAlgorithm(nums);
        System.out.println(Arrays.toString(nums));
    }
}

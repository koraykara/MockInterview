package StriverPlacementSeries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort { // Divide and Merge

    public static void mergeSort(int[] nums) {
        helper(nums, 0, nums.length - 1);
    }

    public static void helper(int[] nums, int low, int high) {
        if (low >= high) return;
        int mid = (low + high) / 2;
        helper(nums, low, mid);
        helper(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }

    public static void merge(int[] nums, int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp.add(nums[left++]);
            } else {
                temp.add(nums[right++]);
            }
        }
        while (left <= mid) {
            temp.add(nums[left++]);
        }
        while (right <= high) {
            temp.add(nums[right++]);
        }
        for (int i = low; i <= high; i++) {
            nums[i] = temp.get(i - low);
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 4, 1, 5, 2, 6, 4};
        mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}

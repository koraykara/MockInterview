package StriverPlacementSeries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountInversions {
    /*
    Global inversions:
        0 <= i < j < n
        nums[i] > nums[j]
    Local Inversions:
        0 <= i < n - 1
        nums[i] > nums[i + 1]
     */

    public static boolean isIdealPermutation(int[] nums) {
        int[] globalInversion = new int[1];
        int localInversion = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) localInversion++;
        }
        helper(nums, 0, nums.length - 1, globalInversion);
        return globalInversion[0] == localInversion;
    }

    public static void helper(int[] nums, int low, int high, int[] globalInversion) {
        if (low >= high) return;
        int mid = (low + high) / 2;
        helper(nums, low, mid, globalInversion);
        helper(nums, mid + 1, high, globalInversion);
        merge(nums, low, mid, high, globalInversion);
    }

    public static void merge(int[] nums, int low, int mid, int high, int[] globalInversion) {
        List<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp.add(nums[left++]);
            } else {
                globalInversion[0] += (mid - left + 1);
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
        int[] nums = {1, 2, 0};
        System.out.println(isIdealPermutation(nums));
    }
}

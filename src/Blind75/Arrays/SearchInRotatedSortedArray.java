package Blind75.Arrays;

public class SearchInRotatedSortedArray {

    public static int search(int[] nums, int target) {
        int pivotIndex = findPivotIndex(nums);
        int index1 = binarySearch(nums, target, 0, pivotIndex-1);
        if(index1 != -1) return index1;
        return binarySearch(nums, target, pivotIndex, nums.length-1);
    }

    public static int binarySearch(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int findPivotIndex(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = -1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (left == right) return left;
            if (mid - 1 >= 0 && mid + 1 < nums.length && nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1])
                return mid;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(search(nums, target));
    }
}

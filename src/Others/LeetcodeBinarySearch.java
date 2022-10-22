package Others;

public class LeetcodeBinarySearch {

    public static int search(int[] nums, int target) {
        int low = 0, high = nums.length;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(mid >= nums.length) break;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                low = mid+1;
            else if(nums[mid] > target)
                high = mid-1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println(search(nums, target));
    }
}

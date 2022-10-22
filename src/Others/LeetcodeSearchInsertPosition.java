package Others;

public class LeetcodeSearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        int foundIndex = Integer.MAX_VALUE;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(mid >= nums.length) break;
            if(nums[mid] == target){
                foundIndex = mid;
                break;
            }
            else if(nums[mid] < target) {
                low = mid + 1;
                foundIndex = high+1;
                if (foundIndex == 0)
                {
                    break;
                }
                else{}
            }
            else {
                high = mid - 1;
                foundIndex = high;
            }
        }
        return foundIndex;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 7;
        System.out.println(searchInsert(nums, target));
    }
}

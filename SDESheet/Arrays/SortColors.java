package SDESheet.Arrays;

import java.util.Arrays;

public class SortColors {

    public static void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        while(mid <= high){
            if(nums[mid] == 0){
                swap(nums, low, mid);
                low++;
                mid++;
            }
            else if(nums[mid] == 1){
                mid++;
            }
            else{
                // value of current index is 2
                swap(nums, mid, high);
                mid++;
                high--;
            }
        }
    }
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0}; //0,1,2 -> red, white, blue
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}

package Others;

import java.util.Arrays;
import java.util.HashSet;

public class AlvinTwoSumProblem {

    public static int[] twoSum(int[] nums, int target) {
        HashSet<Integer> set = new HashSet<>();
        int[] returnedArray = new int[2];
        int index1 = 0;
        int index2 = 0;
        for(int i=0;i<nums.length;i++) {
            if(!set.contains(target - nums[i])){
                set.add(nums[i]);
            }
            else{
                index2 = i;
                for(int j=0;j<nums.length;j++){
                    if(nums[j] == target - nums[index2] && j != index2){
                        index1 = j;
                    }
                }
                break;
            }
        }
        returnedArray[0] = index1;
        returnedArray[1] = index2;
        return returnedArray;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}

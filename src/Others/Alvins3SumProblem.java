package Others;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Alvins3SumProblem {

    public static List<List<Integer>> threeSum(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        List<List<Integer>> returnedList = new ArrayList<>();
        for(int i=0;i<nums.length-1;i++){
            List<Integer> temp = new ArrayList<>();
            int sumOfFirstTwo = nums[i] + nums[i+1];
            for(int j=i+2;j<nums.length;j++){
                if(!set.contains(-(sumOfFirstTwo+nums[j]))){
                    set.add(nums[i]);
                    set.add(nums[i+1]);
                    set.add(nums[j]);
                }
                else{
                    temp.add(nums[i]);
                    temp.add(nums[i+1]);
                    temp.add(-(sumOfFirstTwo));
                    break;
                }
            }
            Collections.sort(temp);
            if(temp.size() != 0 && !returnedList.contains(temp)) returnedList.add(temp);
        }
        return returnedList;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,-2};
        System.out.println(threeSum(nums));
    }
}

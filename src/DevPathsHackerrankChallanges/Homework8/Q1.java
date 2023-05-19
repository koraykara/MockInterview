package DevPathsHackerrankChallanges.Homework8;

import javax.sound.sampled.EnumControl;
import java.util.*;

public class Q1 {

    public static List<Integer> itemsSort(List<Integer> nums) {
        int[] numsArr = new int[nums.size()];
        int i = 0;
        for(int val: nums) numsArr[i++] = val;
        int[] res = helper(numsArr);
        List<Integer> result = new ArrayList<>();
        for(int val: res){
            result.add(val);
        }
        Collections.reverse(result);
        return result;
    }

    public static int[] helper(int[] nums) {
        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (Integer) nums[i];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                if(map.get(a).equals(map.get(b))) {
                    return b - a;
                }
                return map.get(b) - map.get(a);
            }
        });
        return Arrays.stream(arr).mapToInt(Integer::valueOf).toArray();
    }




    public static void main(String[] args) {
        int n = 6;
        List<Integer> items = new ArrayList<>(Arrays.asList(3,1,2,2,4));
        System.out.println(itemsSort(items));
    }
}

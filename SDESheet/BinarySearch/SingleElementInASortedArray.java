package SDESheet.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class SingleElementInASortedArray {

    // TC:O(n) where n is the number of elements in the array
    // SC: O(1)
    public static int singleNonDuplicate(ArrayList<Integer> arr) {
        //    Write your code here.
        int ret = 0;
        for (int num : arr) {
            ret ^= num;
        }
        return ret;
    }

    // TC: O(log(n)) where n is the number of elements in the array
    // SC: O(1)
    public static int singleNonDuplicateOptimal(ArrayList<Integer> arr) {
        int low = 0;
        int high = arr.size() - 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr.get(mid).equals(arr.get(mid ^ 1))) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return arr.get(low);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(1);
        arr.add(2);
        arr.add(2);
        arr.add(4);
        arr.add(5);
        arr.add(5);
        System.out.println(singleNonDuplicate(arr));
        System.out.println(singleNonDuplicateOptimal(arr));
    }
}

package DevPathsHackerrankChallanges.Homework8;

import java.util.*;

public class Q2 {

    public static int getMinimumUniqueSum(List<Integer> arr) {
        int[] res = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            res[i] = arr.get(i);
        }
        return minSum(res);
    }

    public static int minSum(int[] arr) {
        Arrays.sort(arr);
        int sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                int j = i;
                while (j < arr.length && arr[j] <= arr[j - 1]) {
                    arr[j] += 1;
                    j++;
                }
            }
            sum += arr[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 2));
        System.out.println(getMinimumUniqueSum(arr));
    }
}

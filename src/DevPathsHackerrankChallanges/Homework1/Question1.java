package DevPathsHackerrankChallanges.Homework1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question1 {

    public static int minDiff(List<Integer> arr) {
        // Write your code here
        Collections.sort(arr);
        int sum = 0;
        for(int i=0;i<arr.size()-1;i++){
            sum += Math.abs(arr.get(i) - arr.get(i+1));
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(3);
        arr.add(3);
        arr.add(2);
        arr.add(4);
        System.out.println(minDiff(arr));
    }
}

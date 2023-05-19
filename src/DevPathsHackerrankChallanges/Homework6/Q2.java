package DevPathsHackerrankChallanges.Homework6;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Q2 {


    public static int minOperations(List<Integer> arr) {
        return Math.min(lowToHigh(arr), highToLow(arr));
    }

    public static int lowToHigh(List<Integer> arr){
        int count = 0;
        for(int i=0;i<arr.size()-1;i++){
            if(i % 2 == 0) {
                if (arr.get(i) >= arr.get(i+1)) {
                    count++;
                    i++;
                }
            }
            else{
                if(arr.get(i) <= arr.get(i+1)){
                    count++;
                    i++;
                }
            }
        }
        return count;
    }

    public static int highToLow(List<Integer> arr){
        int count = 0;
        for(int i=0;i<arr.size()-1;i++){
            if(i % 2 == 0) {
                if (arr.get(i) <= arr.get(i+1)) {
                    count++;
                    i++;
                }
            }
            else{
                if(arr.get(i) >= arr.get(i+1)){
                    count++;
                    i++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(2);
        arr.add(9);
        System.out.println(minOperations(arr));
    }
}

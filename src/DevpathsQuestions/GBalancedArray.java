package DevpathsQuestions;

import java.util.ArrayList;
import java.util.List;

public class GBalancedArray {

    public static int balancedSumBad(List<Integer> arr){
        int size = arr.size();
        for(int i=0;i<size;i++){
            int leftSubArrSum = 0;
            int rightSubArrSum = 0;
            for(int j=0;j<i;j++){
                leftSubArrSum += arr.get(j);
            }
            for(int j=i+1;j<size;j++){
                rightSubArrSum += arr.get(j);
            }
            if(leftSubArrSum == rightSubArrSum)
                return i;
        }
        return -1;
    }

    public static int balancedSum(List<Integer> arr){
        int leftSubArrSum = 0;
        int sum = findSumOfElements(arr);
        int pivotIndex = 0;
        for(int num: arr){
            if(sum - num - leftSubArrSum == leftSubArrSum){
                return pivotIndex;
            }
            leftSubArrSum += arr.get(pivotIndex++);
        }
        return -1;
    }

    public static int findSumOfElements(List<Integer> arr){
        int total = 0;
        for(int num: arr){
            total += num;
        }
        return total;
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(7);
        arr.add(3);
        arr.add(6);
        arr.add(5);
        arr.add(6);
        System.out.println(balancedSum(arr));
    }
}

package Others;

import java.util.Arrays;

public class LeetcodePeekIndexInMountainArray {

    public static int peakIndexInMountainArray(int[] arr) {
        int[] tempArr = new int[arr.length];
        int i=0;
        for(int num: arr) {
            tempArr[i] = num;
            i++;
        }
        Arrays.sort(tempArr);
        int peak = tempArr[tempArr.length-1];
        System.out.println(Arrays.toString(arr));
        System.out.println(peak);
        return findIndexOfPeakElement(arr, peak);
    }

    public static int findIndexOfPeakElement(int[] arr, int peak){
        int low = 0, high = arr.length;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(mid >= arr.length) break;
            if(arr[mid] == peak)
                return mid;
            else if(arr[mid] < peak)
                low = mid+1;
            else if(arr[mid] > peak)
                high = mid-1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {0,2,1,0};
        System.out.println(peakIndexInMountainArray(arr));
    }
}

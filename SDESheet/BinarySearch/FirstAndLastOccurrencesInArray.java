package SDESheet.BinarySearch;

public class FirstAndLastOccurrencesInArray {

    public static int count(int[] arr, int n, int x) {
        //Your code goes here
        int lowerBound = findLowerBound(arr, x);
        int upperBound = findUpperBound(arr, x);
        return upperBound - lowerBound;
    }

    public static int findLowerBound(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        int res = arr.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= x) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    public static int findUpperBound(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        int res = arr.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > x) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        /*
            for 3
            lower bound: 5
            upper bound: 7
         */
        int[] arr = {1, 1, 1, 2, 2, 3, 3};
        System.out.println(count(arr, arr.length, 3));
    }
}

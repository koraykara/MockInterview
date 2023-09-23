package SDESheet.BinarySearch;

public class SearchInRotatedSortedArray {

    // TC: O(log(n)) where n is the number of elements in the array
    // SC: O(1)
    public static int search(int[] arr, int key) {
        // Write your code here.
        if (arr.length == 0) return -1;
        if (arr.length == 1) {
            if (arr[0] == key) return 0;
            else return -1;
        }
        int peekPoint = findPeekPoint(arr);
        if (peekPoint == -1) return binarySearch(arr, key, 0, arr.length - 1);
        else {
            if (arr[peekPoint] == key) return peekPoint;
            int leftPart = binarySearch(arr, key, 0, peekPoint - 1);
            if(leftPart != -1) return leftPart;
            return binarySearch(arr, key, peekPoint+1, arr.length-1);
        }
    }

    public static int binarySearch(int[] arr, int key, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key) return mid;
            else if (key < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int findPeekPoint(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (low == high) return low;
            if (mid - 1 >= 0 &&
                    mid + 1 < arr.length && arr[mid - 1] < arr[mid] && arr[mid + 1] < arr[mid]) {
                return mid;
            } else if (arr[mid] < arr[low]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        int key = 0;
        System.out.println(search(arr, key));
    }
}

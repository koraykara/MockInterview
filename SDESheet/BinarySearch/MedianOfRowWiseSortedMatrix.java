package SDESheet.BinarySearch;

public class MedianOfRowWiseSortedMatrix {

    // TC: O(m * log(n)) where m is number of row and n is the number of column
    // SC: O(1)
    public static int findMedian(int[][] matrix, int m, int n) {
        // m is row, n is column
        // Write your code here
        int low = findMin(matrix);
        int high = findMax(matrix);
        int middle = (m * n + 1) / 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            for (int r = 0; r < m; r++) {
                count += countNumbersLessThanOrEqualToMid(matrix, r, mid);
            }
            if (count >= middle) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static int countNumbersLessThanOrEqualToMid(int[][] matrix, int row, int midVal) {
        int low = 0;
        int high = matrix[0].length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (midVal >= matrix[row][mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static int findMin(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        for (int[] ints : matrix) {
            if (min > ints[0]) {
                min = ints[0];
            }
        }
        return min;
    }

    public static int findMax(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        for (int[] ints : matrix) {
            if (max < ints[matrix[0].length - 1]) {
                max = ints[matrix[0].length - 1];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int m = 5;
        int n = 5;
        int[][] matrix = {{1, 5, 7, 9, 11},
                {2, 3, 4, 8, 9},
                {4, 11, 14, 19, 20},
                {6, 10, 22, 99, 100},
                {7, 15, 17, 24, 28}};
        // System.out.println(findMedian(matrix, m, n));
        System.out.println(countNumbersLessThanOrEqualToMid(matrix, 0, 10));
        System.out.println(findMedian(matrix, m, n));
    }
}

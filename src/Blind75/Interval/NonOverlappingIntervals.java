package Blind75.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NonOverlappingIntervals {

    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0 || intervals.length == 1) return 0;
        int count = 0;
        int[][] sortedIntervals = sortIntervals(intervals);
        List<List<Integer>> intervalList = createCopyAsList(sortedIntervals);
        for (int i = 0; i < intervalList.size() - 1; i++) {
            if (isOverlapping(intervalList.get(i), intervalList.get(i + 1))) {
                if (intervalList.get(i).get(1) > intervalList.get(i + 1).get(1)) {
                    intervalList.remove(intervalList.get(i));
                } else {
                    intervalList.remove(intervalList.get(i + 1));
                }
                i--;
                count++;
            }
        }
        return count;
    }

    public static List<List<Integer>> createCopyAsList(int[][] intervals) {
        List<List<Integer>> output = new ArrayList<>();
        for (int[] interval : intervals) {
            output.add(new ArrayList<>(Arrays.asList(interval[0], interval[1])));
        }
        return output;
    }

    public static boolean isOverlapping(List<Integer> interval, List<Integer> interval2) {
        return !(interval2.get(1) <= interval.get(0) || interval2.get(0) >= interval.get(1));
    }

    public static int[][] sortIntervals(int[][] intervals) {
        helper(intervals, 0, intervals.length - 1);
        return intervals;
    }

    public static void helper(int[][] intervals, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            helper(intervals, start, mid);
            helper(intervals, mid + 1, end);
            mergeSort(intervals, start, mid, end);
        }
    }

    public static void mergeSort(int[][] intervals, int start, int mid, int end) {
        int partitionSize1 = mid - start + 1;
        int partitionSize2 = end - mid;

        int[][] partition1 = new int[partitionSize1][2];
        int[][] partition2 = new int[partitionSize2][2];

        for (int i = 0; i < partitionSize1; i++) {
            partition1[i][0] = intervals[start + i][0];
            partition1[i][1] = intervals[start + i][1];
        }

        for (int j = 0; j < partitionSize2; j++) {
            partition2[j][0] = intervals[mid + 1 + j][0];
            partition2[j][1] = intervals[mid + 1 + j][1];
        }

        int i = 0;
        int j = 0;
        int k = start;

        while (i < partitionSize1 && j < partitionSize2) {
            if (partition1[i][0] <= partition2[j][0]) {
                intervals[k][0] = partition1[i][0];
                intervals[k][1] = partition1[i][1];
                i++;
            } else {
                intervals[k][0] = partition2[j][0];
                intervals[k][1] = partition2[j][1];
                j++;
            }
            k++;
        }

        while (i < partitionSize1) {
            intervals[k][0] = partition1[i][0];
            intervals[k][1] = partition1[i][1];
            k++;
            i++;
        }

        while (j < partitionSize2) {
            intervals[k][0] = partition2[j][0];
            intervals[k][1] = partition2[j][1];
            k++;
            j++;
        }
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(eraseOverlapIntervals(intervals));
    }
}

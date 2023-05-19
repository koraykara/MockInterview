package Blind75.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class mergeIntervals {

    public static int[][] merge(int[][] intervals) {
        if(intervals.length == 0 || intervals.length == 1) return intervals;
        int[][] sortedIntervals = sortIntervals(intervals);
        List<List<Integer>> copyList = createCopyAsList(sortedIntervals);
        List<List<Integer>> result = mergeIntervals(copyList);
        int[][] res = new int[result.size()][result.get(0).size()];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                res[i][j] = result.get(i).get(j);
            }
        }
        return res;
    }

    public static List<List<Integer>> mergeIntervals(List<List<Integer>> intervalList){
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < intervalList.size(); i++) {
            int currentX = intervalList.get(i).get(0);
            int currentY = intervalList.get(i).get(1);
            if (i + 1 < intervalList.size() && currentY >= intervalList.get(i + 1).get(0)) {
                while (i + 1 < intervalList.size() && currentY >= intervalList.get(i + 1).get(0)) {
                    currentY = Math.max(currentY, intervalList.get(i + 1).get(1));
                    i++;
                }
                result.add(new ArrayList<>(Arrays.asList(currentX, currentY)));
            } else {
                result.add(new ArrayList<>(Arrays.asList(currentX, currentY)));
            }
        }
        return result;
    }

    public static int[][] sortIntervals(int[][] intervals) {
        helper(intervals, 0, intervals.length-1);
        return intervals;
    }

    public static void helper(int[][] intervals, int start, int end){
        if(start < end){
            int mid = (start + end) / 2;
            helper(intervals, start, mid);
            helper(intervals, mid+1, end);
            mergeSort(intervals, start, mid, end);
        }
    }

    public static void mergeSort(int[][] intervals, int start, int mid, int end){
        int partitionSize1 = mid - start + 1;
        int partitionSize2 = end - mid;

        int[][] partition1 = new int[partitionSize1][2];
        int[][] partition2 = new int[partitionSize2][2];

        for(int i=0;i<partitionSize1;i++){
            partition1[i][0] = intervals[start + i][0];
            partition1[i][1] = intervals[start + i][1];
        }

        for(int j=0;j<partitionSize2;j++){
            partition2[j][0] = intervals[mid + 1 + j][0];
            partition2[j][1] = intervals[mid + 1 + j][1];
        }

        int i=0;
        int j=0;
        int k = start;

        while (i < partitionSize1 && j < partitionSize2){
            if(partition1[i][0] <= partition2[j][0]){
                intervals[k][0] = partition1[i][0];
                intervals[k][1] = partition1[i][1];
                i++;
            }
            else{
                intervals[k][0] = partition2[j][0];
                intervals[k][1] = partition2[j][1];
                j++;
            }
            k++;
        }

        while (i < partitionSize1){
            intervals[k][0] = partition1[i][0];
            intervals[k][1] = partition1[i][1];
            k++;
            i++;
        }

        while (j < partitionSize2){
            intervals[k][0] = partition2[j][0];
            intervals[k][1] = partition2[j][1];
            k++;
            j++;
        }
    }

    public static List<List<Integer>> createCopyAsList(int[][] intervals) {
        List<List<Integer>> output = new ArrayList<>();
        for (int[] interval : intervals) {
            output.add(new ArrayList<>(Arrays.asList(interval[0], interval[1])));
        }
        return output;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,4}, {0,4}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }
}

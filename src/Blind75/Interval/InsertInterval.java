package Blind75.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

    public static int[][] insertBad(int[][] intervals, int[] newInterval) {
        if (newInterval.length == 0) return intervals;
        if (intervals.length == 0) return new int[][]{newInterval};
        int rowSize = intervals.length;
        int colSize = intervals[0].length;
        List<List<Integer>> result = new ArrayList<>();
        int x = newInterval[0];
        int y = newInterval[1];
        boolean entered = false;
        for (int i = 0; i < rowSize; i++) {
            int currentX = intervals[i][0];
            int currentY = intervals[i][1];
            result.add(new ArrayList<>(Arrays.asList(currentX, currentY)));
        }
        for (int i = 0; i < result.size(); i++) {
            if (i == result.size() - 1 && result.get(i).get(0) <= x) {
                result.add(i + 1, new ArrayList<>(Arrays.asList(x, y)));
                break;
            } else {
                if (result.get(i).get(0) <= x && result.get(i + 1).get(0) >= x) {
                    result.add(i + 1, new ArrayList<>(Arrays.asList(x, y)));
                    break;
                }
            }
        }
        if (result.size() == intervals.length) {
            result.add(0, new ArrayList<>(Arrays.asList(x, y)));
        }
        System.out.println(result);
        List<List<Integer>> newIntervals = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            int currentX = result.get(i).get(0);
            int currentY = result.get(i).get(1);
            if (i + 1 < result.size() && currentY >= result.get(i + 1).get(0)) {
                while (i + 1 < result.size() && currentY >= result.get(i + 1).get(0)) {
                    currentY = Math.max(currentY, result.get(i + 1).get(1));
                    i++;
                }
                newIntervals.add(new ArrayList<>(Arrays.asList(currentX, currentY)));
            } else {
                newIntervals.add(new ArrayList<>(Arrays.asList(currentX, currentY)));
            }
        }
        int[][] res = new int[newIntervals.size()][newIntervals.get(0).size()];
        System.out.println(newIntervals);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                res[i][j] = newIntervals.get(i).get(j);
            }
        }
        return res;
    }

    // Much Better
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> result = new ArrayList<>();
        if (intervals == null) return null;
        if (intervals.length == 0) return new int[][]{new int[]{newInterval[0], newInterval[1]}};
        List<List<Integer>> output = createCopyAsList(intervals);
        int x = newInterval[0];
        int y = newInterval[1];
        if (intervals.length == 1) {
            if (x <= intervals[0][0]) {
                output.add(0, new ArrayList<>(Arrays.asList(newInterval[0], newInterval[1])));
            } else {
                output.add(1, new ArrayList<>(Arrays.asList(newInterval[0], newInterval[1])));
            }
            if (isOverlapping(output.get(0), output.get(1))) {
                result.add(new ArrayList<>(Arrays.asList(Math.min(output.get(0).get(0), output.get(1).get(0)), Math.max(output.get(0).get(1), output.get(1).get(1)))));
            }
            else{
                if(newInterval[0] <= intervals[0][0]){
                    result.add(new ArrayList<>(Arrays.asList(newInterval[0], newInterval[1])));
                    result.add(new ArrayList<>(Arrays.asList(intervals[0][0], intervals[0][1])));
                }
                else {
                    result.add(new ArrayList<>(Arrays.asList(intervals[0][0], intervals[0][1])));
                    result.add(new ArrayList<>(Arrays.asList(newInterval[0], newInterval[1])));
                }
            }
        } else {
            int len = intervals.length;
            boolean isInserted = false;
            for (int i = 0; i < len; i++) {
                if (x <= intervals[i][0]) {
                    output.add(i, new ArrayList<>(Arrays.asList(newInterval[0], newInterval[1])));
                    isInserted = true;
                    break;
                }
            }
            if(!isInserted){
                output.add(new ArrayList<>(Arrays.asList(newInterval[0], newInterval[1])));
            }
            for (int i = 0; i < output.size(); i++) {
                int currentX = output.get(i).get(0);
                int currentY = output.get(i).get(1);
                if (i + 1 < output.size() && currentY >= output.get(i + 1).get(0)) {
                    while (i + 1 < output.size() && currentY >= output.get(i + 1).get(0)) {
                        currentY = Math.max(currentY, output.get(i + 1).get(1));
                        i++;
                    }
                    result.add(new ArrayList<>(Arrays.asList(currentX, currentY)));
                } else {
                    result.add(new ArrayList<>(Arrays.asList(currentX, currentY)));
                }
            }
        }
        System.out.println(output);
        System.out.println(result);
        int[][] res = new int[result.size()][result.get(0).size()];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                res[i][j] = result.get(i).get(j);
            }
        }
        return res;
    }

    public static List<List<Integer>> createCopyAsList(int[][] intervals) {
        List<List<Integer>> output = new ArrayList<>();
        for (int[] interval : intervals) {
            output.add(new ArrayList<>(Arrays.asList(interval[0], interval[1])));
        }
        return output;
    }

    public static boolean isOverlapping(List<Integer> interval, List<Integer> insertedInterval) {
        return !(insertedInterval.get(1) < interval.get(0) || insertedInterval.get(0) > interval.get(1));
    }

    public static void main(String[] args) {
        int[][] intervals = {{2,6}, {7,9}};
        int[] newInterval = {15, 18};
        System.out.println(Arrays.deepToString(insert(intervals, newInterval)));
    }
}

package StriverPlacementSeries;

import java.util.*;

public class MergeIntervals {


    public static int[][] merge(int[][] intervals) {
        int size = intervals.length;
        List<List<Integer>> res = new ArrayList<>();
        int[][] sortedIntervals = sortIntervals(intervals);
        System.out.println(Arrays.deepToString(sortedIntervals));
        for (int i = 0; i < size; i++) {
            if(res.isEmpty() || sortedIntervals[i][0] > res.get(res.size()-1).get(1)){
                List<Integer> newInterval = new ArrayList<>();
                newInterval.add(sortedIntervals[i][0]);
                newInterval.add(sortedIntervals[i][1]);
                res.add(newInterval);
            }
            else {
                int x1 = res.get(res.size()-1).get(0);
                int yMax = Math.max(sortedIntervals[i][1], res.get(res.size()-1).get(1));
                List<Integer> newInterval = new ArrayList<>();
                res.remove(res.size()-1);
                newInterval.add(x1);
                newInterval.add(yMax);
                res.add(newInterval);
            }
        }
        int[][] ans = new int[res.size()][2];
        int idx = 0;
        for(List<Integer> interval: res){
            ans[idx][0] = interval.get(0);
            ans[idx][1] = interval.get(1);
            idx++;
        }
        return ans;
    }

    public static int[][] sortIntervals(int[][] arr){
        mergeSort(arr, 0, arr.length-1);
        return arr;
    }

    public static void mergeSort(int[][] arr, int low, int high){
        if(low >= high) return;
        int mid = (low + high) / 2;
        mergeSort(arr,low,mid);
        mergeSort(arr,mid+1,high);
        merge(arr, low, mid, high);
    }

    public static void merge(int[][] arr, int low, int mid, int high){
        int left = low;
        int right = mid+1;
        List<List<Integer>> ans = new ArrayList<>();
        while(left <= mid && right <= high){
            List<Integer> list = new ArrayList<>();
            if(arr[left][0] <= arr[right][0]){
                list.add(arr[left][0]);
                list.add(arr[left][1]);
                left++;
            }
            else{
                list.add(arr[right][0]);
                list.add(arr[right][1]);
                right++;
            }
            ans.add(list);
        }
        while(left <= mid){
            List<Integer> list = new ArrayList<>();
            list.add(arr[left][0]);
            list.add(arr[left][1]);
            left++;
            ans.add(list);
        }
        while(right <= high){
            List<Integer> list = new ArrayList<>();
            list.add(arr[right][0]);
            list.add(arr[right][1]);
            right++;
            ans.add(list);
        }
        for(int i=low;i<=high;i++){
            arr[i][0] = ans.get(i-low).get(0);
            arr[i][1] = ans.get(i-low).get(1);
        }
    }

    public static void main(String[] args) {
        int[][] intervals = {{2, 6}, {1, 3}, {15, 18}, {5, 10}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }
}

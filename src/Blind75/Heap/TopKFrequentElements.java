package Blind75.Heap;

import java.util.*;

public class TopKFrequentElements {

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[k];
        for (int val : nums) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        for (int i = 0; i < k; i++) {
            int max = Integer.MIN_VALUE;
            int mostFreqKey = -1;
            for (int key : map.keySet()) {
                if (map.get(key) > max) {
                    max = map.get(key);
                    mostFreqKey = key;
                }
            }
            map.remove(mostFreqKey);
            res[i] = mostFreqKey;
        }
        return res;
    }

    // Time : O(n)
    // Space: O(n)
    public static int[] topKFrequent2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> memo = new ArrayList<>();
        for (int i = 0; i < nums.length+1; i++) {
            memo.add(new ArrayList<>());
        }
        int[] res = new int[k];
        for (int val : nums) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        for (int key : map.keySet()) {
            memo.get(map.get(key)).add(key);
        }
        int index = 0;
        for (int i = memo.size() - 1; i >= 0; i--) {
            if (k == 0) break;
            for (int j = 0; j < memo.get(i).size(); j++) {
                if (memo.get(i).size() != 0) {
                    res[index++] = memo.get(i).get(j);
                    k--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent2(nums, k)));
    }
}

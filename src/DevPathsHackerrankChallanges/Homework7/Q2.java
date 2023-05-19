package DevPathsHackerrankChallanges.Homework7;

import java.util.*;

public class Q2 {

    public static int countPairs(List<Integer> numbers, int k) {
        int count = 0;
        int n = numbers.size();

        // Pick all elements one by one
        for (int i = 0; i < n; i++) {
            // See if there is a pair
            // of this picked element
            for (int j = i + 1; j < n; j++)
                if (numbers.get(i) - numbers.get(j) == k ||
                        numbers.get(j) - numbers.get(i) == k) {
                    count++;
                }
        }
        return count;
    }

    public static int countPairs2(List<Integer> numbers, int k) {
        int count = 0;
        int len = numbers.size();
        Set<String> set = new HashSet<>();
        String str = "";
        Collections.sort(numbers);
        for (int i = 0; i < len; i++) {
            int searched = numbers.get(i) - k;
            int left = i;
            int right = len - 1;
            int mid = (left + right) / 2;
            while (left < right) {
                if (numbers.get(mid) == searched) {
                    count++;
                } else if (numbers.get(mid) < searched) {
                    left++;
                } else {
                    right--;
                }
            }

        }

        for (int i = 0; i < len; i++) {
            int searched = k - numbers.get(i);
            int left = i;
            int right = len - 1;
            int mid = (left + right) / 2;
            while (left < right) {
                if (numbers.get(mid) == searched) {
                    count++;
                } else if (numbers.get(mid) < searched) {
                    left++;
                } else {
                    right--;
                }
            }

        }
        return count;
    }

    public static int countKDifference(List<Integer> numbers, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int res = 0;
        Set<String> visited = new HashSet<>();
        for (Integer number : numbers) {
            if (map.containsKey(number - k)) {
                res += map.get(number - k);
                visited.add(number + "," + k);
            }
            if (map.containsKey(number + k)) {
                res += map.get(number + k);
                visited.add(number + "," + k);
            }
            map.put(number, map.getOrDefault(number, 0) + 1);
        }
        return visited.size();
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 1, 1, 2));
        int k = 1;
        System.out.println(countKDifference(numbers, k));
    }
}

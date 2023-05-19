package Blind75.String;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {


    // Time: O(n^2)
    // Space: O(n)
    // BAD SOLUTION!!
    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        Set<Character> visited = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            int count = 1;
            visited.add(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                if (!visited.contains(s.charAt(j))) {
                    count++;
                    max = Math.max(max, count);
                    visited.add(s.charAt(j));
                } else {
                    visited.clear();
                    break;
                }
            }
            max = Math.max(max, count);
        }
        return max;
    }

    public static int lengthOfLongestSubstringGoodSolution(String s) {
        int left = 0;
        int right = 0;
        int max = 0;
        Set<Character> visited = new HashSet<>();
        while (right < s.length()) {
            while (visited.contains(s.charAt(right))){
                visited.remove(s.charAt(left));
                left++;
            }
            visited.add(s.charAt(right));
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(lengthOfLongestSubstringGoodSolution(s));
    }
}

package Blind75.String;

import java.util.HashSet;
import java.util.Set;

public class PalindromicSubstrings {

    public static int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(s.substring(i, j + 1))) {
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean isPalindrome(String s) {
        if (s.isEmpty() || s.length() == 1) return true;
        int left = 0;
        int end = s.length() - 1;
        while (left < end) {
            if (s.charAt(left) != s.charAt(end)) {
                return false;
            }
            left++;
            end--;
        }
        return true;
    }

    // MORE OPTIMAL SOLUTION BELOW

    public static int countSubstringsMoreOptimal(String s) {
        if (s.isEmpty() || s.length() == 1) return s.length();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += helper(s, i);
        }
        return count;
    }

    public static int helper(String s, int mid) {
        int count = 0;
        int left = mid;
        int right = mid;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                count++;
            }
            else break;
        }
        left = mid;
        right = mid+1;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                count++;
            }
            else break;
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(countSubstringsMoreOptimal(s));
    }
}

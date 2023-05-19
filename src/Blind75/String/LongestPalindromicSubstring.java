package Blind75.String;

public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) return s;
        int len = s.length();
        int longestPalindromeLen = 0;
        String longestPalindrome = "";
        for (int i = 0; i < len; i++) {
            int[] indices = expand(s, i);
            int left = indices[0];
            int right = indices[1] + 1;
            int newLen = right - left;
            if (newLen > longestPalindromeLen) {
                longestPalindromeLen = newLen;
                longestPalindrome = s.substring(left, right);
            }
        }
        return longestPalindrome;
    }

    public static int[] expand(String s, int mid) {
        int left = mid - 1;
        int right = mid + 1;
        while (left > 0){
            if(s.charAt(mid) == s.charAt(left)){
                left--;
            }
            else break;
        }
        while (right < s.length()){
            if(s.charAt(mid) == s.charAt(right)){
                right++;
            }
            else break;
        }
        while (left >= 0 && right < s.length()){
            if(s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }
            else break;
        }
        return new int[]{left+1, right-1};
    }

    public static void main(String[] args) {
        String s = "baaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        System.out.println(longestPalindrome(s));
    }
}

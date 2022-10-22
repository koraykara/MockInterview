package Others;

public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] memo = new boolean[len][len];
        int longestPalindromeSize = 0;
        String longestPalindrome = "";

        // initialize memo
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                memo[i][j] = false;
            }
        }
        // for len = 1
        for (int i=0;i<len;i++){
            memo[i][i] = true;
            longestPalindrome = s.substring(i,i);
        }
        // for len = 2
        for(int i=0;i<len-2;i++){
            if(s.charAt(i) == s.charAt(i+1)){
                memo[i][i+1] = true;
                if(longestPalindromeSize < s.substring(i,i+1).length()){
                    longestPalindrome = s.substring(i,i+1);
                    longestPalindromeSize = longestPalindrome.length();
                }
            }
        }
        return longestPalindrome;
    }

    public static void main(String[] args) {
        
    }
}

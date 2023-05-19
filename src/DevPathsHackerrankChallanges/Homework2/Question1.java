package DevPathsHackerrankChallanges.Homework2;

import java.util.ArrayList;
import java.util.List;

public class Question1 {

    static int CountPS(String s)
    {
        // create empty 2-D matrix that counts all
        // palindrome substring. dp[i][j] stores counts of
        // palindromic substrings in st[i..j]
        int n = s.length();
        int dp[][] = new int[n][n];

        // P[i][j] = true if substring str[i..j] is
        // palindrome, else false
        boolean P[][] = new boolean[n][n];

        // palindrome of single length
        for (int i = 0; i < n; i++)
            P[i][i] = true;

        // palindrome of length 2
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                P[i][i + 1] = true;
                dp[i][i + 1] = 1;
            }
        }

        // Palindromes of length more than 2. This loop is
        // similar to Matrix Chain Multiplication. We start
        // with a gap of length 2 and fill the DP table in a
        // way that gap between starting and ending indexes
        for (int gap = 2; gap < n; gap++) {
            // Pick starting point for current gap
            for (int i = 0; i < n - gap; i++) {
                // Set ending point
                int j = gap + i;

                // If current string is palindrome
                if (s.charAt(i) == s.charAt(j) && P[i + 1][j - 1])
                    P[i][j] = true;

                // Add current palindrome substring ( + 1)
                // and rest palindrome substring (dp[i][j-1]
                // + dp[i+1][j]) remove common palindrome
                // substrings (- dp[i+1][j-1])
                if (P[i][j] == true)
                    dp[i][j] = dp[i][j - 1] + dp[i + 1][j]
                            + 1 - dp[i + 1][j - 1];
                else
                    dp[i][j] = dp[i][j - 1] + dp[i + 1][j]
                            - dp[i + 1][j - 1];
            }
        }

        // return total palindromic substrings
        return dp[0][n - 1];
    }

    public static int countPalindromes(String s) {
        int size = s.length();
        int count = 0;
        for(int i=0;i<=size;i++){
            for(int j=i+1;j<=size;j++){
                if(isPalindrome(s.substring(i,j))){
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean isPalindrome(String s){
        boolean result = true;
        int size = s.length();
        for(int i=0;i<size;i++){
            if(s.charAt(i) != s.charAt(size-i-1)){
                result = false;
                break;
            }
        }
        return result;
    }

    public static int countPalindromes2(String a) {
        int globalCount = a.length();
        for (int mid = 1; mid < a.length() - 1; mid++) {
            int count = 0;

            int low = mid - 1;
            int high = mid + 1;
            while (low >= 0 && high < a.length() && a.charAt(low--) == a.charAt(high++))
                count++;

            globalCount += count;
            count = 0;

            low = mid - 1;
            high = mid;
            while (low >= 0 && high < a.length() && a.charAt(low--) == a.charAt(high++))
                count++;

            globalCount += count;
        }

        return globalCount;
    }


    public static int countPalindromeSubstrings(String string) {
        // başlangıç ve bitiş indekslerini tutan bir liste oluştur
        List<int[]> indices = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            for (int j = i; j < string.length(); j++) {
                indices.add(new int[] {i, j});
            }
        }

        // tüm alt dizileri döndür
        List<String> substrings = new ArrayList<>();
        for (int[] index : indices) {
            substrings.add(string.substring(index[0], index[1] + 1));
        }

        // palindrom alt dizileri say
        int count = 0;
        for (String substring : substrings) {
            if (isPalindrome(substring)) {
                count++;
            }
        }
        return count;
    }

    // bir dizenin palindrom olup olmadığını kontrol eden bir yardımcı metod
    public static boolean isPalindrome2(String string) {
        return string.equals(new StringBuilder(string).reverse().toString());
    }


    public static void main(String[] args) {
        String str = "abccba";
        System.out.println(countPalindromes2(str));

        System.out.println(countPalindromes(str));

        System.out.println(countPalindromeSubstrings(str));
    }
}

package Others;

import java.io.IOException;

class Result {

    /*
     * Complete the 'repeatedString' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. LONG_INTEGER n
     */

    public static long repeatedString(String s, long n) {
        // Write your code here
        long stringSize = s.length();
        long countA = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == 'a')
                countA++;
        }

        long totalANum = n / stringSize * countA; // num of a's
        long remainder = n % s.length();

        for(int i=0;i<remainder;i++) {
            if(s.charAt(i) == 'a')
                totalANum++;
        }
        return totalANum;
    }

} // ab ab ab ab ab a -> 6

class Solution {
    public static void main(String[] args) throws IOException {
        String s = "aba";

        long n = 10;

        long result = Result.repeatedString(s, n);

        System.out.println(result);
    }
}

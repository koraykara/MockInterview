package DevPathsHackerrankChallanges.Homework2;

import java.util.Arrays;

public class Question2 {


    public static int countPerms(int n) {
        int a = 0;
        int e = 1;
        int i = 2;
        int o = 3;
        int u = 4;
        int modulo = (int) (1e9 + 7);
        long[] dp = new long[5]; // We have 5 characters in total
        long[] previousDp = new long[5];
        Arrays.fill(previousDp, 1L);
        while (n > 1) {
            dp[a] = (previousDp[e] + previousDp[i] + previousDp[u]) % modulo;
            dp[e] = (previousDp[a] + previousDp[i]) % modulo;
            dp[i] = (previousDp[e] + previousDp[o]) % modulo;
            dp[o] = previousDp[i];
            dp[u] = (previousDp[i] + previousDp[o]) % modulo;
            long[] tmp = dp;
            dp = previousDp;
            previousDp = tmp;
            n--;
        }
        return (int) ((previousDp[a] + previousDp[e] + previousDp[i] + previousDp[o] + previousDp[u]) % modulo);
    }

    public static int countVowelPermutation(int n) {
        int a = 0, e = 1, i = 2, o = 3, u = 4, MOD = (int) (1e9 + 7);
        long[] dp = new long[5], prevDP = new long[5];
        Arrays.fill(prevDP, 1L);
        while (n-- > 1) {
            dp[a] = (prevDP[e] + prevDP[i] + prevDP[u]) % MOD;
            dp[e] = (prevDP[a] + prevDP[i]) % MOD;
            dp[i] = (prevDP[e] + prevDP[o]) % MOD;
            dp[o] = prevDP[i];
            dp[u] = (prevDP[i] + prevDP[o]) % MOD;
            long[] tmp = dp; dp = prevDP; prevDP = tmp;
        }
        return (int) ((prevDP[a] + prevDP[e] + prevDP[i] + prevDP[o] + prevDP[u]) % MOD);
    }

    public static void main(String[] args) {
        int n = 1;
        System.out.println(countPerms(n));
    }
}

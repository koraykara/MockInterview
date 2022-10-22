package DynamicProgramming.Tabulation;

// Leetcode Solution

public class Fibonacci {
    public static long fib(int n) {
        long[] table = new long[n+1];
        table[0] = 0;
        table[1] = 1;
        for(int i=2;i<=n;i++){
            table[i] = table[i-1] + table[i-2];
        }
        return table[n];
    }

    public static void main(String[] args) {
        System.out.println(fib(50));
    }
}

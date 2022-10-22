package DynamicProgramming.Tabulation;

import java.util.Arrays;

public class gridTravaler {

    public static long gridTraveler(int m, int n){
        long[][] table = new long[m+1][n+1];
        table[1][1] = 1; // base case
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                long current = table[i][j];
                if(j+1 <= n)  table[i][j+1] += current;
                if(i+1 <= m) table[i+1][j] += current;

            }
        }
        System.out.println(Arrays.deepToString(table));
        return table[m][n];
    }

    public static void main(String[] args) {
        System.out.println(gridTraveler(18,18));
    }
}

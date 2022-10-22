package DynamicProgramming.Tabulation;

import java.util.Arrays;

public class CanSum {

    // m = targetSum
    // n = numbers.length
    // O(m*n) time
    // O(m) space
    public static boolean canSum(int targetSum, int[] numbers){
        int numSize = numbers.length;
        boolean[] table = new boolean[targetSum +1];
        table[0] = true;
        for(int i = 0; i< targetSum; i++){
            for (int number : numbers) {
                try {
                    if (table[i]) {
                        table[i + number] = true;
                    }
                } catch (Exception ignored) {
                }
            }
        }
        System.out.println(Arrays.toString(table));
        return table[targetSum];
    }

    public static void main(String[] args) {
        System.out.println(canSum(8, new int[]{2,3,5}));
    }
}

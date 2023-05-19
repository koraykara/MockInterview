package Blind75.DynamicProgramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

public class LongestCommonSubsequence {

    public static int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] table = new int[len1 + 1][len2 + 1];
        int row = table.length;
        int col = table[0].length;
        char[] text1Array = text1.toCharArray();
        char[] text2Array = text2.toCharArray();
        for (int r = row - 1; r >= 0; r--) {
            for (int c = col - 1; c >= 0; c--) {
                try {
                    if (text1Array[r] == text2Array[c]) {
                        table[r][c] = Math.max(table[r][c], 1 + table[r + 1][c + 1]);
                    } else {
                        table[r][c] = Math.max(table[r + 1][c], table[r][c + 1]);
                    }
                } catch (Exception ignored) {
                }
            }
        }
        System.out.println(Arrays.deepToString(table));
        return table[0][0];
    }


    public static int longestCommonSubsequenceSecondSolution(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] table = new int[len1][len2];
        int index = -1;
        for (int i = 0; i < len2; i++) {
            if (text1.charAt(0) == text2.charAt(i)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < len2; i++) {
                table[0][i] = 1;
            }
        }
        index = -1;
        for (int i = 0; i < len1; i++) {
            if (text1.charAt(i) == text2.charAt(0)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < len1; i++) {
                table[i][0] = 1;
            }
        }
        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if(text1.charAt(i) == text2.charAt(j)){
                    table[i][j] = table[i-1][j-1] + 1;
                }
                else{
                    table[i][j] = Math.max(table[i-1][j], table[i][j-1]);
                }
            }
        }
        return table[len1-1][len2-1];
    }

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(longestCommonSubsequenceSecondSolution(text1, text2));
    }
}

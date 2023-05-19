package DevPathsHackerrankChallanges.Homework1;

import java.util.*;

public class Question2 {

    public static long maxProfit2(int costPerCut, int salePrice, List<Integer> lengths) {

        long maxProfit = 0;
        long curProfit = 0;
        int maxLength = 0;
        int totalRods = 0;
        int totalCuts = 0;
        Collections.sort(lengths);
        // Find out maximum length
        for (int curLength : lengths) {
            maxLength = Math.max(maxLength, curLength);
        }

        // For each of the possible rod lengths, calculate possible profit
        for (int curLength = 1; curLength <=maxLength; curLength++) {
            int prevSum=0;
            // Cut each of the rods into smaller rods of size curLength
            // Count total rods and total cuts
            for (int length : lengths) {
                int cut = 0;
                int waste = 0;
                if(length%curLength==0){
                    cut=(length/curLength)-1;
                }else{
                    cut=length/curLength;
                }
                waste=length%curLength;
                prevSum= Math.max(prevSum,prevSum+(length * salePrice - cut * costPerCut -waste * salePrice));
            }

            curProfit=prevSum;
            // Calculate maximum profit
            maxProfit = Math.max(maxProfit, curProfit);
        }

        return maxProfit;
    }


    public static int maxProfit(int costPerCut, int salePrice, List<Integer> lengths) {
        // Write your code here
        Collections.sort(lengths);
        int maxLength = 0;
        int currentProfit = 0;
        int maxProfit = 0;
        for (int curLength : lengths) {
            maxLength = Math.max(maxLength, curLength);
        }

        for (int len = 1; len <=maxLength; len++) {
            int previousSum=0;

            for (int length : lengths) {
                int cut = 0;
                int waste = 0;
                if(length % len==0){
                    cut=(length / len)-1;
                }else{
                    cut=length / len;
                }
                waste=length % len;
                previousSum = Math.max(previousSum,previousSum+(length * salePrice - cut * costPerCut -waste * salePrice));
            }

            currentProfit=previousSum;
            maxProfit = Math.max(maxProfit, currentProfit);
        }

        return maxProfit;
    }

    public static int helper(int costPerCut, int salePrice, int saleLength, List<Integer> lengths){

        int totalUniformRoads = findTotalUniformLods(lengths, saleLength);
        int totalCuts = findTotalCuts(lengths, saleLength);
        int totalRevenue = totalUniformRoads * salePrice * saleLength - totalCuts * costPerCut;
        return totalRevenue;
    }

    public static int findTotalCuts(List<Integer> lengths, int saleLength){
        int result = 0;
        for(int length: lengths){
            if(length % saleLength == 0) {
                result += length / saleLength-1;
            }
            else {
                result += length / saleLength;
            }
        }
        return result;
    }

    public static int findTotalUniformLods(List<Integer> lengths, int saleLength){
        int result = 0;
        for(int length: lengths){
            result += length / saleLength;
        }
        return result;
    }


    public static void main(String[] args) {
        int costPerCut = 1;
        int salePrice = 10;
        List<Integer> lengths = new ArrayList<>();
        lengths.add(26);
        lengths.add(103);
        lengths.add(59);
        System.out.println(maxProfit(costPerCut, salePrice, lengths));
    }
}

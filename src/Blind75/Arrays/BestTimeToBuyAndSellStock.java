package Blind75.Arrays;

public class BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int len = prices.length;
        int max = 0;
        while (left < len && right < len) {
            if(prices[left] > prices[right]){
                left = right;
                right++;
            }
            else {
                int profit = prices[right] - prices[left];
                if(profit > max){
                    max = profit;
                }
                right++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }
}

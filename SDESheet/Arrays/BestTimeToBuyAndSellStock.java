package SDESheet.Arrays;

public class BestTimeToBuyAndSellStock {

    // TC: O(n) where n is the number of price in the input
    // SC: O(1)
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int currentBuy = prices[0];
        for(int i=1;i<prices.length;i++){
            int profit = 0;
            if(prices[i] < currentBuy){
                currentBuy = prices[i];
            }
            else{
                profit = prices[i] - currentBuy;
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}

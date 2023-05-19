package Blind75.DynamicProgramming;

public class CoinChangeTopDown {
    public static int coinChange(int[] coins, int amount) {
        int[] table = new int[amount + 1];
        table[0] = 0;
        for (int i = 1; i < table.length; i++) {
            table[i] = 10001;
        }
        for (int newAmount = 1; newAmount < table.length; newAmount++) {
            for (int coin : coins) {
                int difference = newAmount - coin;
                if (difference >= 0) {
                    table[newAmount] = Math.min(table[newAmount], 1 + table[difference]);
                }
            }
        }
        return table[amount] > amount ? -1 : table[amount];
    }

    public static void main(String[] args) {
        int[] coins = {2, 3, 5};
        int amount = 8;
        System.out.println(coinChange(coins, amount));
    }
}

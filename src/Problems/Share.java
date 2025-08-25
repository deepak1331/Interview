package src.Problems;

/***
 * You are given an array of integers prices, where prices[i] represents the price of a stock on the i-th day.
 *
 * Design an algorithm to find the maximum profit you can achieve from a single buy-sell transaction. You must buy the stock before you sell it.
 *
 * Return the maximum profit you can achieve. If no profit is possible, return 0.
 *
 * Example Input:
 * prices = [7, 1, 5, 3, 6, 4]
 * Expected Output:
 * 5 (Buy on day 2 at price 1 and sell on day 5 at price 6)
 */
public class Share {
    public static void main(String[] args) {

        int[] prices = new int[]{8,1,12, 4, 6, 2, 5, 9};

        int maxProfit = 0;
        int buyIndex = 0;
        int sellIndex = 0;
        int profit = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] < prices[j]) {
                    profit = prices[j] - prices[i];
                    if(maxProfit<profit) {
                        maxProfit = profit;
                        buyIndex = i;
                        sellIndex = j;
                    }
                }
            }
        }

        System.out.printf("Buy on Day: %d & Sell on Day: %d to Make Maximum Profit: %d",
                buyIndex + 1, sellIndex + 1, maxProfit);

    }
}

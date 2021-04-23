package 五毒.第六周.第一遍;

public class best_time_to_buy_and_sell_stock_with_cooldown {
    /**
     * 解题思路
     * dp[i][0],第i天持有股票时的最大收益
     * dp[i][1],第i天不持有股票，在冰冻期的最大收益
     * dp[i][2],第i天不持有股票，不在冰冻期的最大收益
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int[][] dp = new int[prices.length][3];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][2]-prices[i]);
            dp[i][1] = dp[i-1][0]+prices[i];
            dp[i][2] = Math.max(dp[i-1][2],dp[i-1][1]);
        }
        return Math.max(dp[prices.length-1][1],dp[prices.length-1][2]);
    }
}

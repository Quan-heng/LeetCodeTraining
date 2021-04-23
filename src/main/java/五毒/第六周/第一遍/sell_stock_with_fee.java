package 五毒.第六周.第一遍;

public class sell_stock_with_fee {
    /**
     * 解题思路
     * dp[i][0]，第i天不持有股票
     * dp[i][1], 第i天持有股票
     * dp[i][0] = max(dp[i-1][0],dp[i-1][1]+price[i]-fee)
     * dp[i][1] = max(dp[i-1][1],dp[i-1][0]-price[i])
     *
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if (n < 2) {
            return 0;
        }
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n-1][0];
    }
}

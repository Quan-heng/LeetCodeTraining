package 五毒.第六周.第一遍;

public class sell_stock_iv {
    /**
     * 解题思路
     * dp[i][j][k],
     * i：第i天
     * j:0不持有股票，1持有股票
     * k:发生了k次交易，如果超过数组长度的两倍则k = len/ 2,多余的交易无法达到
     * 注意：买入股票时视为发生了一次交易
     *
     * @param k
     * @param prices
     * @return
     */
    public static int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (len <= 1) return 0;
        k = Math.min(k, len / 2); //
        int[][][] dp = new int[len][2][k + 1];
        for (int i = 0; i <= k; i++) {
            dp[0][0][i] = 0;
            dp[0][1][i] = -prices[0];
        }

        for (int i = 1; i < len; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][0][j] = Math.max(dp[i - 1][0][j], dp[i - 1][1][j] + prices[i]);
                dp[i][1][j] = Math.max(dp[i - 1][1][j], dp[i - 1][0][j - 1] - prices[i]);
            }
        }

        return dp[len - 1][0][k];
    }

    public static void main(String[] args) {
        int[] prices = new int[]{3,2,6,5,0,3};
        System.out.println( maxProfit(2,prices));
    }
}

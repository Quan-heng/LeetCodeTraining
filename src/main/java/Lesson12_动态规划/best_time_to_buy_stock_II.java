package Lesson12_动态规划;

/**
 * dp[i]代表i之前的最大收益
 * 1.price[i]>price[i-1],dp[i] = dp[i-1] + prices[i]-price[i-1]
 * 2.price[i]<=price[i-1],dp[i] = dp[i-1];
 */
public class best_time_to_buy_stock_II {
    /**
     * 解法一
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        if(prices.length==1) return 0;
        int[] dp = new int[prices.length];
        dp[0] = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                dp[i] = dp[i-1]+prices[i]-prices[i-1];
            }else{
                dp[i] = dp[i-1];
            }
        }
        return dp[prices.length-1];
    }

    /**
     * 解法二
     * dp[i][0],dp[i][1]
     * 0代表持有现金，1代表持有股票
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices){
        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return dp[len-1][0];
    }
}

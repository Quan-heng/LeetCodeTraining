package 五毒.第六周.第一遍;

public class best_time_to_buy_and_sell_stock_iii {
    public static  int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int[][][] dp = new int[len][2][3];
        int minValue = Integer.MIN_VALUE/2;  //防止越界
        dp[0][0][0] = 0;
        dp[0][0][1] = minValue;
        dp[0][0][2] = minValue;
        dp[0][1][0] = -prices[0];
        dp[0][1][1] = minValue;
        dp[0][1][2] = minValue;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0][0] = 0;
            dp[i][0][1] = Math.max(dp[i - 1][1][0] + prices[i], dp[i - 1][0][1]);
            dp[i][0][2] = Math.max(dp[i - 1][1][1] + prices[i], dp[i - 1][0][2]);
            dp[i][1][0] = Math.max(dp[i - 1][0][0] - prices[i], dp[i - 1][1][0]);
            dp[i][1][1] = Math.max(dp[i - 1][0][1] - prices[i], dp[i - 1][1][1]);
            dp[i][1][2] = minValue;
        }
        return Math.max(Math.max(dp[len - 1][0][1], dp[len - 1][0][2]), 0);
    }

    public static void main(String[] args) {
        int[] prices = new int[]{3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(prices));
    }
}

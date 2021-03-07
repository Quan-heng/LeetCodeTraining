package Lesson12_动态规划;

/**
 * 解题思路：动态规划
 * dp[i+1]代表前i右侧最大的值，dp[i+1]-price[i]为从i到length-1区间最大的收益
 * 从后往前，找出收益最大值
 */
public class best_time_to_buy_stock {
    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    /**
     * 解法一
     * 思路: 从前往后dp
     * dp[i][0] = max(dp[i-1][1]+prices[i],0)
     * dp[i][1] = -prices[i];
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[len - 1][0];
    }

    /**
     * 解法二
     * 思路：从后往前dp，不断找右侧最大值。
     *
     * @param prices
     * @return
     */
    public static int maxProfit1(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int[] dp = new int[prices.length];
        int max = 0;
        dp[prices.length - 1] = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            max = Math.max(dp[i + 1] - prices[i], max);//计算i到len-1区间内的最大值。
            if (dp[i + 1] >= prices[i]) {
                dp[i] = dp[i + 1];
            } else {
                dp[i] = prices[i];
            }
        }
        return max;
    }
}

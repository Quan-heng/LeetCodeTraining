package 每日一题;

public class best_time_to_buy_and_sell_stock {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                res += (prices[i] - prices[i - 1]);
            }
        }
        return res;
    }
}

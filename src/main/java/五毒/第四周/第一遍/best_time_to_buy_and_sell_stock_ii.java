package 五毒.第四周.第一遍;

public class best_time_to_buy_and_sell_stock_ii {
    public int maxProfit(int[] prices) {
        int result =0;
        if(prices.length<=1){
            return 0;
        }
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                result +=(prices[i]-prices[i-1]);
            }
        }
        return result;
    }
}

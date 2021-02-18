package 贪心算法;

/**
 * 买卖股票的最佳时期
 * 思路：贪心算法，
 * 只要后一天比前一天高，就在前天买，后天卖
 * 时间复杂度O(N)
 * 空间复杂度O(1)
 */
public class Test122 {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length<2){
            return 0;
        }
        int res = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                res+=prices[i]-prices[i-1];
            }
        }
        return res;
    }
}



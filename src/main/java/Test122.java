/**
 * 买卖股票的最佳时机 II
 * 思路：贪心算法O(n),只要后一天比前一天大，则在前一天买入，后一天抛出即可
 */
public class Test122 {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length<2) return 0;
        int i = 1;
        int result = 0;
        while(i<prices.length){
            if(prices[i]<=prices[i-1]){
                i++;
            }else {
                int start = i - 1;
                while (i < prices.length && prices[i] > prices[i - 1]) {//找到连续增长的最后一个索引
                    i++;
                }
                int end = i - 1;
                result+=(prices[end]-prices[start]);
            }
        }
        return result;
    }
}

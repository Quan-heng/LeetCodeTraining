package 五毒.第六周.第一遍;

import java.util.Arrays;

public class coin_change {
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount);
        dp[0] =0;
        for(int i=1;i<=amount;i++){
            for(int j = 0;j<coins.length;j++){
                if(i>=coins[j]){
                    dp[i] = Math.min(dp[i-coins[j]]+1,dp[i]);
                }
            }
        }
        return dp[amount]>amount?-1:dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{2};
        System.out.println(coinChange(coins,3));
    }
}

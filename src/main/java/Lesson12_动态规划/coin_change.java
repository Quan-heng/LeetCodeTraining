package Lesson12_动态规划;

import java.util.Arrays;

/**
 * 思路：
 * 1.bfs,求出第一次找到0结点的深度
 * 2.dp和上楼梯问题差不多,每次找f(n-1),f(n-2),f(n-5)里的最小值
 * 分治：
 * dp数组：f(n)= min(f(n-k), for k in [1,2,5]) +1
 *
 */
public class coin_change {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);//dp[i]第一次比较时的默认值，要比amount大
        dp[0] = 0;
        for (int i = 1; i <=amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if(coins[j]<=i){
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount]>amount?-1:dp[amount];

    }
}

package Lesson12_动态规划;

/**
 * 思路：dp[i][j] = dp[i-1][j]+dp[i][j-1]
 * 时间复杂度：o(n*m)
 * 空间复杂度：o(n*m)
 */
public class unique_paths {
    /**
     * 方法一：用二维dp
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 法二：用一维dp
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths1(int m, int n) {
        int dp[] = new int[n+1];
        dp[1] = 1;
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                dp[j]  = dp[j]+dp[j-1];
            }
        }
        return dp[n];
    }

}

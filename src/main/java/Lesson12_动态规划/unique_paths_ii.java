package Lesson12_动态规划;

/**
 * 解题思路：
 * dp[j] = dp[j]+dp[j-1]
 */
public class unique_paths_ii {
    public static void main(String[] args) {
        int[][] obs = new int[][]{{1, 0}};
        System.out.println(uniquePathsWithObstacles(obs));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (obstacleGrid[i - 1][j - 1] == 1) {
                    dp[j] = 0;
                } else {
                    dp[j] = dp[j] + dp[j - 1];//重点理解这里:相当于dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[n];
    }
}

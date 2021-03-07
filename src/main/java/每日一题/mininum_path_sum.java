package 每日一题;

/**
 * dp[i][j] = min(dp[i-1][j],dp[i][j-1])+nums[i][j]
 */
public class mininum_path_sum {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,2},{1,1}};
        minPathSum(grid);
    }
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i - 1][j - 1];
            }
            dp[0] = Integer.MAX_VALUE;
        }
        return dp[n];
    }
}

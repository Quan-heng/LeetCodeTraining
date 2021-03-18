package 每日一题;

public class max_sum_of_rectangle_no_larger_than_k {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int[][] dp = new int[m + 1][n + 1];
                dp[i][j] = matrix[i - 1][j - 1];
                for (int i1 = i; i1 <= m; i1++) {
                    for (int j1 = j; j1 <= n; j1++) {
                        dp[i1][j1] = dp[i1 - 1][j1] + dp[i1][j1 - 1] - dp[i1 - 1][j1 - 1] + matrix[i1 - 1][j1 - 1];
                        if (dp[i1][j1] <= k && dp[i1][j1] > max) {
                            max = dp[i1][j1];
                        }
                    }
                }
            }
        }
        return max;
    }
}

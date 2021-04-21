package 五毒.第六周.第一遍;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            int size = triangle.get(i).size();
            for (int j = 0; j <size;j++){
                dp[i][j] = Math.min(dp[i+1][j],dp[i+1][j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
}

package 每日一题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 解题思路：
 * dp[i][j] = min(triangle[i+1][j] + triangle[i+1][j+1])+triangle[i][j]
 * res = dp[0][0]
 */
public class triangle_min_path {
    public int minimumTotal(List<List<Integer>> triangle) {
        //因为按层递归，只需一维dp即可
        int[] dp = new int[triangle.get(triangle.size() - 1).size()+1];//技巧：假设最下层多一层全为零的边
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
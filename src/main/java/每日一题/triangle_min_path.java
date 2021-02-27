package 每日一题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 解题思路：
 * dp[i][j] = min(triangle[i+1][j] + triangle[i+1][j+1])+triangle[i][j]
 * res = dp[0][0]
 * 时间复杂度为O((1+n)*n/2)) -> O(n^2)
 * 空间复杂度O(n)
 */
public class triangle_min_path {

    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>();
        List<Integer> list1  = new ArrayList<>();
        list1.add(1);
        List<Integer> list2  = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        arr.add(list1);
        arr.add(list2);
        System.out.println(minimumTotal(arr));
    }
    public static int minimumTotal(List<List<Integer>> triangle) {
        //因为按层递归，只需一维dp即可
        int row = triangle.size();
        int[] dp = new int[row+1];//技巧：假设最下层多一层全为零的边
        for (int i = row - 1; i >= 0; i--) {
            for (int j = 0; j < i+1; j++) {//第i行，有i+1个数
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
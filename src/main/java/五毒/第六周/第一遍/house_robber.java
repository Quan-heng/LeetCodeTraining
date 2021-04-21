package 五毒.第六周.第一遍;

public class house_robber {
    public static int rob(int[] nums) {
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i][1] = dp[i-1][0]+nums[i];
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
        }
        return Math.max(dp[nums.length-1][1],dp[nums.length-1][0]);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        System.out.println(rob(nums));
    }
}

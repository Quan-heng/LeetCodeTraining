package Lesson12_动态规划;

/**
 * p[i] = max(p[i-1],p[i-2]+nums[i])
 */
public class house_bobber {

    /**
     * 空间复杂度o(n*2),0代表不打，1代表打
     * dp[i][0] = max(dp[i-1][0],dp[i-1][1])
     * dp[i][1] = dp[i-1][0]+ nums[i]
     *
     * @param nums
     * @return
     */
    public int rob3(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }


    /**
     * 空间复杂度o(1)
     *
     * @param nums
     * @return
     */

    public int rob2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int prev = nums[0];
        int now = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int temp = now;
            now = Math.max(now, prev + nums[i]);
            prev = temp;
        }
        return now;

    }

    /**
     * 空间复杂度 o(n)
     *
     * @param nums
     * @return
     */
    public int rob1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }
}

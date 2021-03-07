package Lesson12_动态规划;

/**
 * 思路：根据打了第一个就不到打最后一个，打了最后一个就不能打第一个
 * 1.分治:可拆分成从第0个到i-2个，从第1个到i-2个两种情况
 * 2.状态方程dp[i] = max(dp[i-1],dp[i-2]+nums[i])
 */
public class house_robbler_II {
    public static void main(String[] args) {
        int[] nums = new int[]{4,1,2,7,5,3,1};
        System.out.println(rob(nums));
    }
    public static int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        if (len == 2) return Math.max(nums[0], nums[1]);

        //0到i-2;
        int prev1 = nums[0];
        int now1 = Math.max(nums[0], nums[1]);
        int temp;
        for (int i = 2; i <= len - 2; i++) {
            temp = now1;
            now1 = Math.max(now1, prev1 + nums[i]);
            prev1 = temp;
        }


        //1到i-1;
        int prev2 = nums[1];
        int now2 = Math.max(nums[1], nums[2]);
        for (int i =3; i <= len - 1; i++) {
            temp = now2;
            now2 = Math.max(now2, prev2 + nums[i]);
            prev2 = temp;
        }
        return Math.max(now1, now2);
    }
}

package 每日一题;

public class house_robber_II {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int[] dp1 = new int[len];
        int[] dp2 = new int[len];
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);
        dp2[0] = 0;
        dp2[1] = nums[1];
        //0 -> i-2
        for (int i = 2; i < len - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + nums[i]);
        }
        // 1 -> i-1
        for (int i = 2; i < len; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i]);
        }
        return Math.max(dp1[len - 2], dp2[len - 1]);
    }
}

package 五毒.第六周.第一遍;

public class maximum_subarray {
    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length+1];
        int max = Integer.MIN_VALUE;
        for(int i=1;i<=nums.length;i++){
            dp[i] = Math.max(dp[i-1],0)+nums[i-1];
            max = Math.max(dp[i],max);
        }
        return max;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        maxSubArray(nums);
    }
}

package 五毒.第六周.第一遍;

public class maximum_product_subarray {
    public int maxProduct(int[] nums) {
        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];

        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        int max =nums[0];
        for (int i = 1; i < nums.length; i++) {
            dpMax[i] = Math.max(Math.max(dpMax[i - 1]*nums[i], nums[i]), dpMin[i - 1] * nums[i]);
            dpMin[i] = Math.min(Math.min(dpMax[i - 1]*nums[i], nums[i]), dpMin[i - 1] * nums[i]);
            max = Math.max(dpMax[i],max);
        }
        return max;

    }
}

package 五毒.第一周.第二遍;

public class container_with_most_water {
    public static int maxArea(int[] height) {
        int result = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            result = Math.max(height[left] < height[right] ?
                    height[left] * (right - left++) :
                    height[right] * (right-- - left),result);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 1, 4};
        System.out.println(maxArea(nums));
    }
}

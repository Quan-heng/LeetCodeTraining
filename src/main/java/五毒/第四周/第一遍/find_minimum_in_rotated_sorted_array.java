package 五毒.第四周.第一遍;

public class find_minimum_in_rotated_sorted_array {
    public static int findMin(int[] nums) {
        int len = nums.length;
        if (nums[len - 1] >= nums[0]) return nums[0];
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (mid >= 1 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            } else if (nums[mid] >= nums[0] && nums[mid] > nums[len - 1]) {//mid在左侧
                left = mid + 1;
            } else if (nums[mid] < nums[0] && nums[mid] <= nums[len - 1]) {//mid在右侧
                right = mid - 1;
            }
        }
        return nums[0];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,4,1,2};
        System.out.println(findMin(nums));
    }
}

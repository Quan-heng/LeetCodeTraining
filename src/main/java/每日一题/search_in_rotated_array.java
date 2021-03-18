package 每日一题;

/**
 * target>nums[0],在左边
 * rarget<nums[0],在右边
 */
public class search_in_rotated_array {
    public static void main(String[] args) {
        int[] nums = new int[]{5,1,3};
        System.out.println(search(nums, 5));
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int len = nums.length;
        int right = len - 1;
        int mid;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[0] && nums[mid] > nums[len - 1] && nums[mid] >= nums[0]) {//mid在左侧，target在右侧
                left = mid + 1;
            } else if (target >= nums[0] && nums[mid] < nums[0] && nums[mid] <= nums[len - 1]) {//mid在右，target在左
                right = mid - 1;
            } else {//在同一侧
                if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}

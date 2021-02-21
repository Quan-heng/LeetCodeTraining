package Lesson11_二分查找;

public class Test153 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if(nums[nums.length-1]>nums[0]){//如果没有旋转，直接返回第一个元素
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if(nums[mid]>=nums[0]&&nums[mid+1]<nums[0]){
                break;
            }
            if (nums[mid] >= nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[mid+1];
    }
}

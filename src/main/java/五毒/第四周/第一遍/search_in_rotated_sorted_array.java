package 五毒.第四周.第一遍;

public class search_in_rotated_sorted_array {
    public int search(int[] nums, int target) {
        //找分界点
        if(target==nums[0]) return 0;
        if(target==nums[nums.length-1]) return nums.length-1;
        int left = 0;
        int right = nums.length-1;
        int mid;
        while(left<=right){
            mid = left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]>=nums[0]&&target<nums[0]){//mid在左，target在右
                left = mid+1;
            }else if(nums[mid]<nums[0]&&nums[mid]<=nums[nums.length-1]&&target>nums[0]){//mid在右，targe在左
                right = mid-1;
            }else{
                if(nums[mid]>target){
                    right=mid-1;
                }else{
                    left = mid+1;
                }
            }
        }
        return -1;

    }
}

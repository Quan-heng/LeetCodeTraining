package 五毒.第一周.第一遍;

public class remove_duplicates_from_sorted_array {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0){
            return nums.length;
        }
        int index=0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]==nums[i-1]||i==index){
                continue;
            }
            nums[++index] = nums[i];
        }
        return index+1;
    }
}

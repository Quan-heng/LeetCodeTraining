package 五毒.第一周.第二遍;

public class remove_duplicates_from_sorted_array {
    public static int removeDuplicates(int[] nums) {
        int index = 0;
        int i = 0;
        while(i<nums.length){
            if(i>0&&nums[i]==nums[i-1]){
                i++;
                continue;
            }
            nums[index++] = nums[i++];
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums= new int[]{1,1,2,3};
        System.out.println(removeDuplicates(nums));
    }
}

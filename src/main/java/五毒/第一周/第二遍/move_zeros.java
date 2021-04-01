package 五毒.第一周.第二遍;

public class move_zeros {
    public static void moveZeroes(int[] nums) {
        int zeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i != zeroIndex && nums[i] != 0) {
                nums[zeroIndex++] = nums[i];
            }
        }
        for(int i = zeroIndex;i<nums.length;i++){
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);
    }
}

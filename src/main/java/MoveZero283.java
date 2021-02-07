import java.util.Arrays;

public class MoveZero283 {

    public static void main(String[] args) {

        int[] nums = new int[]{1, 0, 3, 2};
        moveZeroes(nums);
    }

    /**
     * 解题思路：双指针法
     * 把非零元素往前移，利用指针记录位置，移动后把当前位置置为0。
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != index) {
                    nums[index++] = nums[i];
                    nums[i] = 0;
                } else {
                    index++;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}

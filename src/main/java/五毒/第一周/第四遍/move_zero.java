package 五毒.第一周.第四遍;

public class move_zero {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 0, 2};
        moveZeroes(arr);
    }

    public static void moveZeroes(int[] nums) {
        int noneZeroIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                noneZeroIndex++;
                if (i != noneZeroIndex) {
                    nums[noneZeroIndex] = nums[i];
                    nums[i] = 0;
                }
            }
        }
    }
}

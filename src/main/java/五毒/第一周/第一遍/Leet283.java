package 五毒.第一周.第一遍;

public class Leet283 {
    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != index) {
                    nums[index] = nums[i];
                    nums[i] = 0;
                }
                index++;
            }
        }
    }
}

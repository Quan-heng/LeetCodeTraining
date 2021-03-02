package 五毒.第一周.第一遍;

public class rotate_array {
    public void rotate(int[] nums, int k) {
        int n = 0;
        int index = 0;
        int cur = nums[0];
        while (n <= nums.length) {
            int temp = nums[(index + k) % nums.length];
            nums[(index + k) % nums.length] = cur;
            cur = temp;
            index=(index + k) % nums.length;
            n++;
        }
    }
}

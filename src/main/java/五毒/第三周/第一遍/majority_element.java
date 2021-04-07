package 五毒.第三周.第一遍;

public class majority_element {
    public static void main(String[] args) {

    }

    public int majorityElement(int[] nums) {
        int cur = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (cur == nums[i]) {
                count++;
            } else if (--count == 0) {
                cur = nums[i];
                count = 1;
            }
        }
        return cur;
    }
}

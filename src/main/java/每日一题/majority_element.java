package 每日一题;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class majority_element {
    public int majorityElement1(int[] nums) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int count = map.getOrDefault(nums[i], 0);
            if (count == length / 2) {
                return nums[i];
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return -1;
    }
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}

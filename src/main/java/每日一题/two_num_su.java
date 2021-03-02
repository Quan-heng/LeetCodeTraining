package 每日一题;

import java.util.HashMap;
import java.util.Map;

public class two_num_su {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,4};
        System.out.println(twoSum(nums,6));
    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                return new int[]{map.get(temp),i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{};

    }

}

package 五毒.第二周.第二遍;

import java.util.HashMap;
import java.util.Map;

public class two_sum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(nums[0],0);
        for (int i = 1; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }
}

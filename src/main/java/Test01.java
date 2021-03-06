import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test01 {
    public static void main(String[] args) {

    }
    public static int[] twoSum(int[] nums, int target) {
       Map<Integer,Integer> map = new HashMap<>();
       int[] result = new int[2];

       if(nums==null||nums.length==1){
           return result;
       }

        map.put(nums[0],0);
        for (int i = 1; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])){
                result[0] = map.get(target-nums[i]);
                result[1] = i;
            }else{
               map.put(nums[i],i);
            }
        }
        return result;
    }
}

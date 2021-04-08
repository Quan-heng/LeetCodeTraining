package 五毒.第三周.第二遍;

import java.util.Arrays;

public class majority_elements {
    /**
     * 摩尔投票法
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int candidate= nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if(candidate==nums[i]){
                count++;
            }else{
                if(--count==0){
                    candidate  = nums[i];
                    count=1;
                }
            }
        }
        return candidate;
    }

    /*
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }*/
}

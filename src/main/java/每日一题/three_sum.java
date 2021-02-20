package 每日一题;

import java.util.*;

/**
 * 解题思路：
 * 双指针法
 */
public class three_sum {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length<3){
            return new ArrayList<>();
        }
        int end = nums.length-1;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int target = nums[i];
            if(i>0&&nums[i]==nums[i-1]) continue;
            if(target>0) break;
            int left = i+1;
            int right = end;
            while(left<right){
                if(nums[left]+nums[right]<-target){
                    left++;
                }else if(nums[left]+nums[right]>-target){
                    right--;
                }else{
                    List<Integer> list = new ArrayList<>();
                    list.add(target);
                    list.add(nums[left++]);
                    list.add(nums[right--]);
                    result.add(list);
                    while(left<right&&nums[left-1]==nums[left]){
                        left++;
                    }
                    while(left<right&&nums[right+1]==nums[right]){
                        right--;
                    }
                }
            }
        }
        return result;
    }
}

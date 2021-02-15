package 五毒;

import java.util.*;

public class threenumber {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};//-4,-1,-1,0,1,2
        System.out.println(threeSum(nums));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        if(nums==null||nums.length<3){
            return new ArrayList<>();
        }
        Set<List<Integer>> result= new HashSet<>();
        Arrays.sort(nums);
        int index = 0;
        while (index<nums.length-2&&nums[index]<=0){
            int left = index+1;
            int right = nums.length-1;
            while(left<right){
                int twoSum = nums[left]+nums[right];
                if(twoSum<-nums[index]){
                    left++;
                } else if(twoSum>-nums[index]){
                    right--;
                }else{
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[index]);
                    list.add(nums[left++]);
                    list.add(nums[right--]);
                    result.add(list);
                }
            }
            index++;
        }
        return new ArrayList<>(result);
    }

}

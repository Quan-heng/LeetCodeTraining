package 五毒.第一周.第二遍;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class three_Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length==0){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            if(nums[i]>0) break;
            for(int j=i+1,k=nums.length-1;j<k;){
                int temp = nums[i]+nums[j]+nums[k];
                if(temp==0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
                    j++;
                    k--;
                    while(nums[j]==nums[j-1]&&j<k){
                        j++;
                    }
                    while(nums[k]==nums[k-1]&&j<k){
                        k--;
                    }
                }else if(temp<0){
                    j++;
                    while(nums[j]==nums[j-1]&&j<k){
                        j++;
                    }
                }else{
                    k--;
                    while(nums[k]==nums[k-1]&&j<k){
                        k--;
                    }
                }
            }
        }
        return result;
    }
}

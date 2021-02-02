import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//三数之和等于0
//思路：a+b =-c，排序，逼进, 去重
public class Test15 {
    public static void main(String[] args) {
        int[] nums = new int[]{ -1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }
    public static  List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> temp = new HashSet<List<Integer>>();

        for (int i = 0; i < nums.length-2; i++) {
            if(nums[i]>0){
                break;
            }
            for(int j=i+1,k=nums.length-1;j<k;){
                int twoSum = nums[j] + nums[k];
                if (( twoSum< -nums[i])) {
                    j++;
                } else if(twoSum>nums[i]) {
                    k--;
                } else{
                    temp.add(Arrays.asList(nums[i], nums[j],nums[k]));
                    j++;
                }
            }
        }
        return new ArrayList<List<Integer>>(temp);
    }
}

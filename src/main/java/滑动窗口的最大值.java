import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class 滑动窗口的最大值 {
    public static void main(String[] args) {
       int[] nums = new int[]{1,3,-1,-3,7};

        System.out.println(Arrays.toString(maxSlidingWindow(nums,3)));
    }
    public static  int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length<k||k==0){
            return new int[]{};
        }
        //暴力法
        int[] result = new int[nums.length-k+1];
        int max = Integer.MIN_VALUE;
        int index = 0;

        for(int i=0;i<k;i++){
            if(nums[i]>max){
                max  = nums[i];
            }
        }
        result[index++] = max;
        for(int j=1;j<nums.length-k+1;j++){
            if(nums[j-1]!=max){
                max = Math.max(max,nums[j+k-1]);
                result[index++] = max;
            }else{
                max = Integer.MIN_VALUE;
                for(int i=j;i<j+k;i++){
                    if(nums[i]>max){
                        max = nums[i];
                    }
                }
                result[index++] = max;
            }
        }
        return result;
    }
}

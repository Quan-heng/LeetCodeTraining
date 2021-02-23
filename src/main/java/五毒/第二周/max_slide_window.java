package 五毒.第二周;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class max_slide_window {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,1,2,0,5};
        System.out.println(Arrays.toString(maxSlidingWindow(nums,3)));
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length<k){
            return new int[]{};
        }
        Deque<Integer> queue = new LinkedList<>();
        int[] result = new int[nums.length-k+1];
        for(int i=0;i<nums.length;i++){
            if(!queue.isEmpty()&&i-k==queue.getFirst()){
                queue.removeFirst();
            }
            while(!queue.isEmpty()&&nums[i]>=nums[queue.getLast()]){
                queue.removeLast();
            }
            queue.add(i);

            if(i>=k-1){
                result[i-k+1] = nums[queue.getFirst()];
            }

        }
        return result;
    }
}

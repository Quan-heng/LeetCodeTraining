package 五毒.第一周.第二遍;

import java.awt.geom.QuadCurve2D;
import java.util.*;

public class sliding_window_maximum {
    /**
     * 保证deque里是单调递减
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty()&&nums[i]>= nums[queue.peekLast()]){
                queue.removeLast();
            }
            queue.offerLast(i);
        }
        int[] result = new int[nums.length-k+1];
        result[0] = nums[queue.getFirst()];
        for(int i = k;i<nums.length;i++){
            int left = queue.peekFirst();
            if(left<(i-k+1)){
                queue.removeFirst();
            }
            while(!queue.isEmpty()&&nums[i]>=nums[queue.peekLast()]){
                queue.removeLast();
            }
            queue.offerLast(i);
            result[i-k+1] =nums[queue.getFirst()];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0};
        System.out.println(Arrays.toString(maxSlidingWindow(nums,1)));

    }
}

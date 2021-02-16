package 五毒;

import java.util.*;

/**
 * 解题思路：Deque
 */
public class 滑动窗口239 {
    public static void main(String[] args) {
        int[] nums = new int[]{7,2,4};
        System.out.println(Arrays.toString(maxSlidingWindow(nums,2)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null||k==0||nums.length<k){
            return new int[]{};
        }
        Deque<Integer> queue = new LinkedList<>();
        int[] res = new int[nums.length-k+1];
        int n =0;
        int index = 0;

        //queue.add(0);
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty()&&nums[queue.getLast()]<nums[i]){//1.与尾部元素比较，如果比当前元素小，则删除。
                queue.removeLast();
            }
            queue.addLast(i);
            index++;

            if(!queue.isEmpty()&&queue.getFirst()<n){ //2.如果最左侧不在当前滑动窗口内，则删除左侧(n为滑动窗口左侧边界)
                queue.removeFirst();
            }
            if(index>=k&&!queue.isEmpty()){ //3.向右滑动向数组里添加结果。
                res[n++] = nums[queue.getFirst()];
            }
        }
        return res;
    }
    /**
     * 解法1：优先队列，会超时
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow1(int[] nums, int k) {
        if(nums==null){
            return null;
        }
        if(k==0){
            return null;
        }
        if(nums.length<k){
            return null;
        }
        int[] result = new int[nums.length-k+1];
        int index = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((x,y)->y-x);
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
            if(queue.size()==k){
                result[index]= queue.peek();
                queue.remove(nums[index]);
                index++;
            }
        }
        return result;
    }

}

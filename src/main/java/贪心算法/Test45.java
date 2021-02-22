package 贪心算法;

/**
 * 思路：贪心算法,
 * 从前往后跳，记录下一步能跳跃的最大距离
 */
public class Test45 {
    public int jump(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int step=0;
        for (int i = 0; i < nums.length-1; i++) {//最后一个下标不需要访问
            maxPosition  = Math.max(nums[i]+i,maxPosition);
            if(i==end){
                end = maxPosition;
                step++;
            }
        }
        return step;
    }
}

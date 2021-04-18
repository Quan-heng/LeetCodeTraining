package 五毒.第四周.第一遍;

public class jump_game_ii {
    public int jump(int[] nums) {
        int count = 0;
        int end = 0;
        int max = 0;
        for(int i=0;i<nums.length-1;i++){
            max = Math.max(max,i+nums[i]);
            if(i==end){
                end = max;
                count++;
            }
        }
        return count;
    }
}

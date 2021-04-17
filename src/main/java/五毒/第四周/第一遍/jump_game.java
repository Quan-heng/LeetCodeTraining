package 五毒.第四周.第一遍;

public class jump_game {
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= max) {
                max = Math.max(max, i + nums[i]);
                if(max>=nums.length-1){
                    return true;
                }
            }
        }
        return false;
    }
}

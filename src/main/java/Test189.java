import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//旋转数组：https://leetcode-cn.com/problems/rotate-array/
public class Test189 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,-100,3,99};
        rotate(nums,2);
    }
    public static void rotate(int[] nums, int k) {
        if(nums==null){
            return;
        }
        int[] tempArr = new int[nums.length];
        int step = 0;
        for (int i = 0; i < nums.length; i++) {
            step = i+k;
            if(step>=nums.length){
                step = (step- nums.length)% nums.length;
            }
            tempArr[step] = nums[i];
        }
        for (int i = 0; i < tempArr.length; i++) {
            nums[i] = tempArr[i];
        }
        System.out.println(Arrays.toString(nums));
       // nums = tempArr;
    }
}

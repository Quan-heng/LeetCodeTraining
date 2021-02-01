import java.util.Arrays;

//move zero
public class Test283 {
    public static void main(String[] args) {
      int[] a = new int[]{1,0,3};
      moveZeroes(a);

    }

    public static  void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
           if(nums[i]!=0){
               nums[j++] = nums[i];
           }
        }

        for(int k = j;k<nums.length;k++){
            nums[k]=0;
        }

        System.out.println(Arrays.toString(nums));
    }
}

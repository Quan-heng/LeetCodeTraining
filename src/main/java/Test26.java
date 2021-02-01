public class Test26 {
    public static void main(String[] args) {
      int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int index = 0;
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        for (int i = 1; i < nums.length; i++) {
           if(nums[i]==nums[i-1]){
               continue;
           }else{
               index++;
               if(index!=i){
                   nums[index] = nums[i];
               }
           }
        }
        return index+1;
    }
}

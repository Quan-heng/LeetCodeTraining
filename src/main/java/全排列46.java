import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 思路：回溯（递归）
 */
public class 全排列46 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(permute(nums));
    }
    /*第一遍
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> list = new LinkedList<>();
        dfs(nums, list, result);
        return result;
    }

    public static void dfs(int[] nums, Deque<Integer> list, List<List<Integer>> result) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                dfs(nums, list, result);
                list.removeLast();
            }
        }
    }*/

    //第二版，相对第一版使用一个Bool数组来记录已经使用过的下标，避免重复访问
    public static List<List<Integer>> permute(int[] nums) {
       List<List<Integer>> result = new ArrayList<>();
       if(nums==null){
           return result;
       }
       boolean[] used = new boolean[nums.length];
       Deque<Integer> list = new LinkedList<>();
       dfs(nums,used,list,result);
       return result;
    }

    private static void dfs(int[] nums, boolean[] used, Deque<Integer> list, List<List<Integer>> result) {
        if(list.size()==nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!used[i]){//不访问重复下标
                list.add(nums[i]);
                used[i]=true;
                dfs(nums,used,list,result);
                used[i]=false;
                //reverse
                list.removeLast();
            }
        }
    }

}

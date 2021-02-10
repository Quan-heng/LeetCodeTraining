import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 思路:回溯
 */
public class 子集78 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(subsets(nums));
    }

    //解法1：回溯
    /*public static List<List<Integer>> subsets(int[] nums) {
        if(nums==null){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> queue = new LinkedList<>();
        result.add(new ArrayList<>());
        dfs(nums,0,queue,result);
        return result;
    }

    public static void dfs(int[] nums,int begin, Deque<Integer> queue,List<List<Integer>> res){
        if(queue.size()==nums.length){
            return;
        }
        for(int i=begin;i<nums.length;i++){
            queue.add(nums[i]);
            res.add(new ArrayList<>(queue));
            dfs(nums,i+1,queue,res);
            queue.removeLast();
        }
    }*/
    //解法2：分治(可以看成n个格子，每个格子里元素可选可不选)
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        List<Integer> list = new ArrayList<>();
        dfs(nums, list, result, 0);
        return result;

    }

    public static void dfs(int[] nums, List<Integer> list, List<List<Integer>> result, int index) {
        //terminator
        if (index == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        //process-split
        dfs(nums, list, result, index + 1); //not pick the number
        list.add(nums[index]);
        dfs(nums, list, result, index + 1);//pick the number
        //reverse
        list.remove(list.size()-1);
    }

}

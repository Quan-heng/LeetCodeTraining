import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 思路:回溯
 */
public class 子集78 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
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
    }
}

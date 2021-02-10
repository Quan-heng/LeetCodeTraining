import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class 全排列47 {
    public static void main(String[] args) {
       int[] nums = new int[]{1,2,3};
        System.out.println(permuteUnique(nums));
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> indexList= new LinkedList<>();
        Deque<Integer> queue = new LinkedList<>();
        dfs(nums,indexList,0,queue,result);
        return result.stream().distinct().collect(Collectors.toList());
    }

    public static void dfs(int[] nums, Deque<Integer> indexList, int n, Deque<Integer> queue,List<List<Integer>> result){
        if(queue.size()==nums.length){
            result.add(new ArrayList<>(queue));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!indexList.contains(i)) {
                queue.add(nums[i]);
                indexList.add(i);
                dfs(nums,indexList,i+1,queue,result);
                queue.removeLast();
                indexList.removeLast();
            }
        }
    }
}

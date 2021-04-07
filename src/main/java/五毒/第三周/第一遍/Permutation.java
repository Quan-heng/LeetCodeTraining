package 五毒.第三周.第一遍;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums==null){
            return result;
        }
        boolean[] visited = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        dfs(nums,result,list,visited);
        return result;
    }

    private void dfs(int[] nums, List<List<Integer>> result, List<Integer> list,boolean[] visited) {
        if(list.size()==nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!visited[i]){
                visited[i]=true;
                list.add(nums[i]);
                dfs(nums,result,list,visited);
                visited[i]=false;
                list.remove(list.size()-1);
            }
        }
    }

}

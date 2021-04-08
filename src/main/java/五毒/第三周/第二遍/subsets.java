package 五毒.第三周.第二遍;

import java.util.ArrayList;
import java.util.List;

public class subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        dfs(result,new ArrayList<>(),nums,0);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> subList, int[] nums, int depth) {
        if(depth==nums.length){
            result.add(new ArrayList<>(subList));
            return;
        }

        dfs(result,subList,nums,depth+1);
        subList.add(nums[depth]);
        dfs(result,subList,nums,depth+1);
        subList.remove(subList.size()-1);

    }


}

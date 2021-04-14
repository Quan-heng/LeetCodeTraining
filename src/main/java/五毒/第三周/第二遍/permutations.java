package 五毒.第三周.第二遍;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) return result;
        List<Integer> list = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        dfs(result, list, 0, nums, visited);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, int depth, int[] nums, Set<Integer> visited) {
        if (depth == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited.contains(i)) {
                visited.add(i);
                list.add(nums[i]);
                dfs(result, list, depth + 1, nums, visited);
                visited.remove(i);
                list.remove(list.size()-1);
            }
        }
    }
}

package 五毒.第三周.第二遍;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permutation_ii {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        int depth = 0;
        Arrays.sort(nums);
        dfs(result, list, visited, depth, nums);
        return result;

    }

    private static void dfs(List<List<Integer>> result, List<Integer> list, boolean[] visited, int depth, int[] nums) {
        if (depth == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == false) {
                continue;
            }
            if (visited[i] == false) {
                visited[i] = true;
                list.add(nums[i]);
                dfs(result, list, visited, depth + 1, nums);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        System.out.println(permuteUnique(nums));
    }
}

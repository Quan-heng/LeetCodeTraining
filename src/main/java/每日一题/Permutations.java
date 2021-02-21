package 每日一题;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> list = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        dfs(result, list, nums, used,nums.length);
        return result;
    }

    private void dfs(List<List<Integer>> result, Deque<Integer> list, int[] nums,boolean[] used, int count) {
        if (list.size() == count) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                list.add(nums[i]);
                used[i] = true;
                dfs(result, list, nums, used,count);
                list.removeLast();
                used[i] = false;
            }
        }
    }
}

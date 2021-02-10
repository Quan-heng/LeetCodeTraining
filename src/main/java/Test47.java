import java.util.*;

/**
 * 有重复元素的全排列
 * 思路：1.回溯 2.排序 3.剪枝
 * 如果后一个元素与上一个元素相同，刚不需要排列。
 */
public class Test47 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        System.out.println(permuteUnique(nums));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        Deque<Integer> list = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, list, used, result, 0);
        return result;
    }

    private static void dfs(int[] nums, Deque<Integer> list, boolean[] used, List<List<Integer>> result, int depth) {
        if (depth == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || ((i - 1 >= 0 && nums[i] == nums[i - 1] && used[i - 1]))) {//剪枝
                continue;
            }
            list.add(nums[i]);
            used[i] = true;
            dfs(nums, list, used, result, depth + 1);
            used[i] = false;
            //reverse
            list.removeLast();
        }
    }
}


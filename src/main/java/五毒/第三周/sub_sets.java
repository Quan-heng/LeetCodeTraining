package 五毒.第三周;

import java.util.ArrayList;
import java.util.List;

public class sub_sets {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private static void dfs(List<List<Integer>> result, List<Integer> list, int[] nums, int index) {
        if (index == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        dfs(result,list,nums,index+1);
        list.add(nums[index]);
        dfs(result,list,nums,index+1);
        list.remove(list.size()-1);
    }
}

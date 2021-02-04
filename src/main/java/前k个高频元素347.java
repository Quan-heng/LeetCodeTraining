import javafx.util.Pair;

import java.util.*;

//解题思路，1.HashMap记录单词对应的个数 2.二叉堆，大顶堆（根据value值排序）
//PriorityQueue<Map.Entry<Integer,Integer>> heap = new PriorityQueue<>((x,y)->(y.getValue()-x.getValue()));
public class 前k个高频元素347 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        System.out.println(Arrays.toString(topKFrequent(nums, 3)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        if (nums == null) {
            return result;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((x, y) -> (y.getValue() - x.getValue()));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            heap.add(entry);
        }
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll().getKey();
        }
        return result;
    }
}

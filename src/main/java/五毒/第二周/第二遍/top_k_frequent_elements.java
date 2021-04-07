package 五毒.第二周.第二遍;

import javafx.util.Pair;

import java.util.*;

public class top_k_frequent_elements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int count= map.getOrDefault(nums[i],0);
            map.put(nums[i],count+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<Map.Entry<Integer, Integer>>(k, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        }) ;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(entry);
        }
        int[] result = new int[k];
        for(int i=0;i<k;i++){
            result[i] = queue.poll().getKey();
        }
        return result;
    }
}

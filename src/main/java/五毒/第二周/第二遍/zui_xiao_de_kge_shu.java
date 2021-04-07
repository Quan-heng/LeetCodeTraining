package 五毒.第二周.第二遍;

import java.util.PriorityQueue;
import java.util.Queue;

public class zui_xiao_de_kge_shu {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] result = new int[k];
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            queue.offer(arr[i]);
        }
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll();
        }
        return result;
    }
}

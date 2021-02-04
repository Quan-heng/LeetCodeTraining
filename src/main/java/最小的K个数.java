import java.util.Arrays;
import java.util.PriorityQueue;

public class 最小的K个数 {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 1};
        System.out.println(Arrays.toString(getLeastNumbers(arr, 2)));
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        //方法1，小顶堆，poll前k个元素
        int[] result = new int[k];
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            heap.add(arr[i]);
        }
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll();
        }
        return result;
    }
}

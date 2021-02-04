import java.util.Arrays;
import java.util.PriorityQueue;

public class 滑动窗口的最大值 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(maxSlidingWindow(nums, 3)));
    }


    //大顶堆法(PriorityQueue)
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0) {
            return new int[]{};
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((x, y) -> (y - x));
        int[] result = new int[nums.length - k + 1];
        int i = 0;
        int j = -k + 1;
        int l = 0;
        while (j < nums.length - k + 1) {
            heap.offer(nums[i++]);
            if (j >= 0) {
                result[l++] = heap.peek();
                heap.remove(nums[j]);
            }
            j++;
        }
        return result;
    }

    //双端队列法（Deque）
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        return null;
    }

    //暴力法
    public static int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums.length < k || k == 0) {
            return new int[]{};
        }

        int[] result = new int[nums.length - k + 1];
        int max = Integer.MIN_VALUE;
        int index = 0;

        for (int i = 0; i < k; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        result[index++] = max;
        for (int j = 1; j < nums.length - k + 1; j++) {
            if (nums[j - 1] != max) {
                max = Math.max(max, nums[j + k - 1]);
                result[index++] = max;
            } else {
                max = Integer.MIN_VALUE;
                for (int i = j; i < j + k; i++) {
                    if (nums[i] > max) {
                        max = nums[i];
                    }
                }
                result[index++] = max;
            }
        }
        return result;
    }
}

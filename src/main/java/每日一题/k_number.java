package 每日一题;

import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/get-kth-magic-number-lcci/
 * 解题思路：Deque
 */
public class k_number {
    public static void main(String[] args) {
        System.out.println(getKthMagicNumber(10));
    }

    public static int getKthMagicNumber(int k) {
        if (k <= 1) return k;
        PriorityQueue<Long> queue = new PriorityQueue<>();
        queue.add((long) 1);
        long res = 0;
        for (int i = 1; i <= k; i++) {
            res = queue.poll();
            while(!queue.isEmpty()&&queue.peek()==res) queue.poll();
            queue.add(res * 3);
            queue.add(res * 5);
            queue.add(res * 7);
        }
        return (int) res;
    }
}

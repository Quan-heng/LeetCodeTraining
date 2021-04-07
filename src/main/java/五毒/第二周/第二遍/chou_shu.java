package 五毒.第二周.第二遍;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class chou_shu {

    /**
     * 动态规划
     * @param
     * @return
     */
    /*
    public static int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        for(int i=1;i<n;i++){
            dp[i] = Math.min(Math.min(dp[p2]*2,dp[p3]*3),dp[p5]*5);
            if(dp[i]==dp[p2]*2) p2++;
            if(dp[i]==dp[p3]*3) p3++;
            if(dp[i]==dp[p5]*5) p5++;
        }

        return dp[n-1];
    }*/


    public static int nthUglyNumber(int n) {
        PriorityQueue<Long> queue  = new PriorityQueue<>();
        queue.offer((long)1);
        long result = 0;
        for(int i=0;i<n;i++){
            result = queue.poll();
            while(!queue.isEmpty()&&queue.peek()==result){
                queue.remove(result);
            }
            queue.offer(result*2);
            queue.offer(result*3);
            queue.offer(result*5);
        }
        return (int) result;

    }
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }
}

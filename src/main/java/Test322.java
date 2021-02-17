import javax.print.DocFlavor;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 零钱兑换
 * 思路：贪心算法不能实现
 */
public class Test322 {
    public static void main(String[] args) {
        int[] nums = new int[]{1};
        System.out.println(coinChange(nums,1));
    }
    public static int result=0;
    public static int coinChange(int[] coins, int amount) {
        if(amount==0){
            return 0;
        }
        if(coins==null){
            return -1;
        }
        Arrays.sort(coins);
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < coins.length; i++) {
            stack.push(coins[i]);
        }
        dfs(coins,amount,stack);
        return result;
    }

    private static void dfs(int[] coins, int amount,Deque<Integer> stack) {
        if(stack.isEmpty()&&amount!=0){
            result = -1;
            return;
        }
        if(amount==0){
            return;
        }
        int temp = stack.pop();
        if(amount>=temp){
            int n = amount/temp;
            result+=n;
            amount = amount-n*temp;
        }
        dfs(coins,amount,stack);
        stack.push(temp);
    }
}

package 五毒.第一周.第四遍;

public class climbing_stairs {
    public static void main(String[] args) {

    }

    public int climbStairs(int n){
        if(n<=2){
            return n;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for(int i=2;i<n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n-1];
    }
}

package 五毒.第六周.第一遍;

public class longest_common_subsequence {
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m][n];
        dp[0][0] = text1.charAt(0)==text2.charAt(0)?1:0;
        for(int i=1;i<m;i++){
            if(text1.charAt(i)==text2.charAt(0)){
                dp[i][0] = 1;
            }else{
                dp[i][0] = dp[i-1][0];
            }
        }

        for(int j=1;j<n;j++){
            if(text2.charAt(j)==text1.charAt(0)){
                dp[0][j] = 1;
            }else{
                dp[0][j] = dp[0][j-1];
            }
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(text1.charAt(i)==text2.charAt(j)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        String text1 ="aa" ;
        String text2 ="aaa";
        System.out.println(longestCommonSubsequence(text1,text2));
    }
}

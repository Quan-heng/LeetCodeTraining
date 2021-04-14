public class decoding {

    public static int numDecodings(String s) {
        if (s.startsWith("0")) return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 1) == '0') {
                if (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2') {
                    dp[i] = dp[i - 2];
                } else {
                    return 0;
                }
            } else {
                if (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) >= '0' && s.charAt(i - 1) <= '6')) {
                    dp[i] = dp[i - 1] + dp[i - 2];
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("112"));
    }
}

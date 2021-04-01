package 五毒.第一周.第三遍;

public class climb_stars {
    public int climbStairs(int n) {
        int prev = 1;
        int cur = 2;
        if(n<=2) return n;
        for (int i = 0; i < n; i++) {
            int temp = cur;
            cur = cur+prev;
            prev = temp;
        }
        return cur;
    }
}

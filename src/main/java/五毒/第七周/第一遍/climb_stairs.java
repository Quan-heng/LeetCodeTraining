package 五毒.第七周.第一遍;

public class climb_stairs {
    public int climbStairs(int n) {
        if(n<=2){
            return n;
        }
        int pre = 1;
        int next = 2;
        int result = 0;
        for(int i=2;i<n;i++){
            result = pre+next;
            pre = next;
            next= result;
        }
        return result;
    }
}

import java.util.Arrays;

/**
 * 分发饼干
 * 思路：贪心算法，先给胃口最小的发，升序
 */
public class Test455 {
    public int findContentChildren(int[] g, int[] s) {
        if(g==null||s==null) return 0;
        Arrays.sort(g);//保证数组是升序的
        Arrays.sort(s);
        int i=0;
        int j=0;
        int res = 0;
        while(i<g.length&&j<s.length){
            if(s[j]>=g[i]){
                j++;
                i++;
                res+=1;
            }else{
                j++;//不满足，向后查找饼干
            }
        }
        return res;
    }
}

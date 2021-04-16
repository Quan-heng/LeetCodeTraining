package 五毒.第四周.第一遍;

import java.util.Arrays;

public class assign_cookies {
    public int findContentChildren(int[] g, int[] s) {
        int i=0;
        int j = 0;
        int result =0;
        Arrays.sort(g);
        Arrays.sort(s);
        while(i<g.length&&j<s.length){
            if(s[j]>=g[i]){
                j++;
                i++;
                result++;
            }else{
                j++;
            }
        }
        return result;
    }
}

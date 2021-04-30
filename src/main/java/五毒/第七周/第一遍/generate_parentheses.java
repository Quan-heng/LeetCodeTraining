package 五毒.第七周.第一遍;

import java.util.ArrayList;
import java.util.List;

public class generate_parentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        int left = 0;
        int right = 0;
        dfs(left,right,"",n,result);
        return result;
    }

    private void dfs(int left, int right, String s, int n, List<String> result) {
        if(left==n&&right==n){
            result.add(s);
            return;
        }
        if(left<n){
            dfs(left+1,right,s+"(",n,result);
        }
        if(right<left){
            dfs(left,right+1,s+")",n,result);
        }
    }
}

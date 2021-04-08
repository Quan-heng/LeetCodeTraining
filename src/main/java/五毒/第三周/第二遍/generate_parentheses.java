package 五毒.第三周.第二遍;

import java.util.ArrayList;
import java.util.List;

public class generate_parentheses {
    public List<String> generateParenthesis(int n) {
        int left = 0;
        int right = 0;
        List<String> result = new ArrayList<>();
        dfs(left,right,n,"",result);
        return result;
    }

    private void dfs(int left, int right, int n, String s, List<String> result) {
        if(left==n&&right==n){
            result.add(s);
            return;
        }

        if(left<n){
            dfs(left+1,right,n,s+"(",result);
        }
        if(right<left){
            dfs(left,right+1,n,s+")",result);
        }
    }
}

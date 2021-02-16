import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * 解题思路：深度优先
 */
public class Test22_2 {
    public List<String> generateParenthesis(int n) {
        if(n<1){
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        dfs(0,0,"",n,result);
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
        if(left>right){
            dfs(left,right+1,s+")",n,result);
        }
    }
}

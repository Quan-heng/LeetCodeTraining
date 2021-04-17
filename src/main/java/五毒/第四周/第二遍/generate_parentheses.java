package 五毒.第四周.第二遍;

import java.util.ArrayList;
import java.util.List;

public class generate_parentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(result, "", 0, 0, n);
        return result;
    }

    private void dfs(List<String> result, String s, int left, int right, int n) {
        if (left == n && right == n) {
            result.add(s);
            return;
        }
        if (left < n) {
            dfs(result, s + "(", left + 1, right, n);
        }
        if (right < left) {
            dfs(result, s + ")", left, right + 1, n);
        }
    }
}

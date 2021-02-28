package 五毒.第三周;

import java.util.ArrayList;
import java.util.List;

/**
 * 1.left随时可以添加，只要别超标
 * 2。right<=left
 * 时间复杂度o(2^n)
 */
public class generate_parentheses {
    public List<String> generateParenthesis(int n) {
        int left = 0;
        int right = 0;
        List<String> result = new ArrayList<>();
        dfs(left, right, n, "", result);
        return result;
    }

    private void dfs(int left, int right, int n, String s, List<String> result) {
        if (left == n && right == n) {
            result.add(s);
            return;
        }
        if (left < n) {
            dfs(left + 1, right, n, s + "(", result);
        }
        if (right < left) {
            dfs(left, right + 1, n, s + ")", result);
        }
    }
}

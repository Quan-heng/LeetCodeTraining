import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 解题思路：回溯法
 */
public class 组合77 {
    public static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        Deque<Integer> list = new LinkedList<>();
        System.out.println(combine(4,2));
    }
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> queue = new LinkedList<>();
        dfs(4,2,queue,1,res);
        return res;
    }
    public static void dfs(int n, int k, Deque<Integer> list, int begin,List<List<Integer>> res) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        } else {
            for (int i = begin; i <= n; i++) {
                list.add(i);
                dfs(n, k, list, i + 1,res);
                //reverse 重点理解这里：深度优先遍历有回头的过程，因此递归之前做了什么，递归之后需要做相同操作的逆向操作
                list.removeLast();
            }
        }
    }
}

package 训练场;

import java.util.LinkedList;
import java.util.List;

public class 赛程表问题 {
    public static void main(String[] args) {
        System.out.println(listGameMatch(32));
    }

    public static String listGameMatch(int n) {
        if (n == 0) {
            return "";
        }
        List<String> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(String.valueOf(i));
        }
        return dfs(list);
    }

    private static String dfs(List<String> list) {
        if (list.size() == 2) {
            StringBuilder sb = new StringBuilder();
            sb.append("[").append(list.get(0)).append(",").append(list.get(1)).append("]");
            return sb.toString();
        } else {
            List<String> subList = new LinkedList<>();
            for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
                StringBuilder sb = new StringBuilder();
                sb.append("[").append(list.get(i)).append(",").append(list.get(j)).append("]");
                subList.add(sb.toString());
            }
            return dfs(subList);
        }
    }
}

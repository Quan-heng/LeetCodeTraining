package 五毒.第三周.第二遍;

import java.util.*;

public class n_queens {
    public static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        Set<Integer> shu = new HashSet<>();
        Set<Integer> pie = new HashSet<>();
        Set<Integer> la = new HashSet<>();
        List<List<String>> result = new ArrayList<>();
        int depth = 0;
        List<String> list = new ArrayList<>();
        dfs(result, board, depth, shu, pie, la, n);
        return result;

    }

    private static void dfs(List<List<String>> result, char[][] board, int depth, Set<Integer> shu, Set<Integer> pie, Set<Integer> la, int n) {
        if (depth == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                list.add(String.valueOf(board[i]));
            }
            result.add(list);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!shu.contains(i) && !pie.contains(i + depth) && !la.contains(depth - i)) {
                board[depth][i] = 'Q';
                shu.add(i);
                pie.add(i + depth);
                la.add(depth - i);
                dfs(result, board, depth + 1, shu, pie, la, n);
                board[depth][i] = '.';
                shu.remove(i);
                pie.remove(depth + i);
                la.remove(depth - i);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(6));
    }
}

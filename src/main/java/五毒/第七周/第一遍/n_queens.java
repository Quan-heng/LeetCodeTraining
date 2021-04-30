package 五毒.第七周.第一遍;

import java.util.*;

public class n_queens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        Set<Integer> shu = new HashSet<>();
        Set<Integer> pie = new HashSet<>();
        Set<Integer> la = new HashSet<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i], '.');
        }
        dfs(board, 0, shu, pie, la, result);
        return result;
    }

    private void dfs(char[][] board, int depth, Set<Integer> shu, Set<Integer> pie, Set<Integer> la, List<List<String>> result) {
        if (depth == board.length) {
            List<String> subList = new ArrayList<>();
            for (int k = 0; k < board.length; k++) {
                subList.add(String.valueOf(board[k]));
            }
            result.add(subList);
            return;
        }


        for (int j = 0; j < board.length; j++) {
            if (shu.contains(j) || pie.contains(depth + j) || la.contains(depth - j)) {
                continue;
            }
            shu.add(j);
            pie.add(depth + j);
            la.add(depth - j);
            board[depth][j] = 'Q';
            dfs(board, depth + 1, shu, pie, la, result);
            shu.remove(j);
            pie.remove(depth + j);
            la.remove(depth - j);
            board[depth][j] = '.';

        }
    }
}

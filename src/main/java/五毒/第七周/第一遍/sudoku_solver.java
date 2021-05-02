package 五毒.第七周.第一遍;

public class sudoku_solver {
    public void solveSudoku(char[][] board) {
        dfs(0, board);
    }

    private boolean dfs(int depth, char[][] board) {
        if (depth == 81) {
            return true;
        }
        int m = depth / 9;
        int n = depth % 9;
        if (board[m][n] == '.') {
            for (char i = '1'; i <= '9'; i++) {
                if (isValid(m, n, i, board)) {
                    board[m][n] = i;
                    if (dfs(depth + 1, board)) {
                        return true;
                    } else {
                        board[m][n] = '.';
                    }
                }
            }
        } else {
            return dfs(depth + 1, board);
        }
        return false;
    }

    private boolean isValid(int m, int n, char i, char[][] board) {
        for (int index = 0; index < 9; index++) {
            int row = (m/3)*3+index/3;
            int col = (n/3)*3+index%3;
            if(board[row][col]==i||board[index][n]==i||board[m][index]==i){
                return false;
            }
        }
        return true;
    }
}

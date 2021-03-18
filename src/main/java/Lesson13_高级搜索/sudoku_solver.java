package Lesson13_高级搜索;

import java.util.HashMap;
import java.util.Map;

public class sudoku_solver {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    public boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (int k = '1'; k <= '9'; k++) {
                        if (isValid(board, i, j, (char) k)) {
                            board[i][j] = (char) k;
                            if (solve(board)) {//递归
                                return true;
                            } else {
                                board[i][j] = '.';//回溯
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(char[][] board, int row, int col, char target) {
        for (int i = 0; i < 9; i++) {
            int blocki = row / 3 * 3 + i / 3;
            int blockj = col / 3 * 3 + i % 3;
            if (board[i][col] != '.' && board[i][col] == target) return false;
            if (board[row][i] != '.' && board[row][i] == target) return false;
            if (board[blocki][blockj] != '.' && board[blocki][blockj] == target) return false;
        }
        return true;
    }

}

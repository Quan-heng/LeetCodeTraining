package 五毒.第四周.第一遍;

public class minesweeper {
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
        } else {
            dfs(x, y, board);
        }
        return board;

    }

    private void dfs(int x, int y, char[][] board) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return;
        }
        if (board[x][y] != 'E') {
            return;
        }
        //8个方向
        int[] dx = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            int xTemp = x + dx[i];
            int yTemp = y + dy[i];
            if (xTemp < 0 || xTemp >= board.length || yTemp < 0 || yTemp >= board[0].length) {
                continue;
            }
            if (board[xTemp][yTemp] == 'M') {

                cnt++;
            }
        }
        if (cnt > 0) {
            board[x][y] = (char) ('0' + cnt);
        } else {
            board[x][y] = 'B';
            for (int i = 0; i < 8; i++) {
                int xTemp = x + dx[i];
                int yTemp = y + dy[i];
                dfs(xTemp, yTemp, board);
            }
        }
    }
}

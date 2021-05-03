package 五毒.第七周.第一遍;

import java.util.Deque;
import java.util.LinkedList;

public class shortest_path_in_binary_matrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[] dx = new int[]{-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dy = new int[]{-1, 0, 1, 1, 1, 0, -1, -1};
        int m = grid.length;
        int n = grid[0].length;
        if (m == 1 && grid[0][0] == 0) return 1;
        if (grid[m - 1][n - 1] == 1||grid[0][0]==1) return -1;
        Deque<int[]> queue = new LinkedList<>();
        queue.addLast(new int[]{0, 0});
        grid[0][0] = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] position = queue.removeFirst();
                int x = position[0];
                int y = position[1];
                int count = grid[x][y];
                for (int j = 0; j < 8; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if (isValid(nx, ny, m, n)&&grid[nx][ny] == 0) {
                        grid[nx][ny] = count + 1;
                        queue.addLast(new int[]{nx, ny});
                    }
                    if (nx == m - 1 && ny == n - 1 && grid[m - 1][n - 1] != 0) {
                        return grid[m - 1][n - 1];
                    }
                }
            }
        }
        return -1;
    }

    private boolean isValid(int nx, int ny, int m, int n) {
        return nx >= 0 && nx < m && ny >= 0 && ny < n;
    }
}

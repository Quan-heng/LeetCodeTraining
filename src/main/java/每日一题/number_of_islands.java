package 每日一题;

public class number_of_islands {
    public int numIslands(char[][] grid) {
        int width = grid[0].length;
        int height = grid.length;
        int res = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(i, j, height, width, grid);
                }
            }
        }
        return res;
    }

    private void dfs(int i, int j, int height, int width, char[][] grid) {
        if (i < 0 || i >= height || j < 0 || j >= width) {
            return;
        }
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
        }else{
            return;
        }
        dfs(i - 1, j, height, width, grid);
        dfs(i + 1, j, height, width, grid);
        dfs(i, j - 1, height, width, grid);
        dfs(j, j + 1, height, width, grid);
    }
}

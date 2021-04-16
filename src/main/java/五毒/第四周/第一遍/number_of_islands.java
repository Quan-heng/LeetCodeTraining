package 五毒.第四周.第一遍;

public class number_of_islands {

    public static int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    dfs(i, j, grid);
                }
            }
        }
        return result;
    }

    private static void dfs(int i, int j, char[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
            dfs(i - 1, j, grid);
            dfs(i + 1, j, grid);
            dfs(i, j - 1, grid);
            dfs(i, j + 1, grid);
        }

    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(numIslands(grid));

    }
}

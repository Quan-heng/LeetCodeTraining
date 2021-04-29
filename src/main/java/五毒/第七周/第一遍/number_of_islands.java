package 五毒.第七周.第一遍;

public class number_of_islands {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    //合并上下左右
                    int index = i * n + j;
                    if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                        uf.union(index, i * n + j - 1);
                    }
                    if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                        uf.union(index, (i - 1) * n + j);
                    }
                    if (j + 1 < n && grid[i][j + 1] == '1') {
                        uf.union(index, i * n + j + 1);
                    }
                    if (i + 1 < m && grid[i + 1][j] == '1') {
                        uf.union(index, (i + 1) * n + j);
                    }
                }
            }
        }
        return uf.getCount();
    }

    private class UnionFind {
        private int _count;
        private int[] _parent;

        public UnionFind(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            _parent = new int[n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        _parent[i * n + j] = i * n + j;
                        _count++;
                    }
                }
            }
        }

        public int find(int p) {
            while (p != _parent[p]) {
                _parent[p] = _parent[_parent[p]];
                p = _parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            _parent[rootP] = rootQ;
            _count--;
        }

        public int getCount() {
            return _count;
        }
    }
}

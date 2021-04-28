package 五毒.第七周.第一遍;

public class number_of_provinces {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        UnionFind uf = new UnionFind(n);
        for(int i = 0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1){
                    uf.union(i,j);
                }
            }
        }
        return uf.getCount();
    }

    private class UnionFind {
        private int count;
        private int[] parent;

        public UnionFind(int n) {
            count = n;
            parent = new int[count];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int parentP = find(p);
            int parentQ = find(q);
            if (parentP == parentQ) return;
            parent[parentQ] = parentP;
            count--;

        }

        public int getCount(){
            return count;
        }
    }
}
